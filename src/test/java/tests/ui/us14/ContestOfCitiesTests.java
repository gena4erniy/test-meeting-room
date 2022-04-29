package tests.ui.us14;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

@Epic("Login")
@Feature("US 1.4")
public class ContestOfCitiesTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;

    public ContestOfCitiesTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @DataProvider(name = "dataTest")
    public Object[][] dataTest() {
        return new Object[][]{
                {
                        countriesPage.getSelectBelarus(),
                        belarusCitiesChoose.getButtonGomel(),
                        belarusCitiesChoose.getButtonMinsk(),
                        "Гомеля нет в списке",
                        "Минска нет в списке"
                },
                {
                        countriesPage.getSelectRussia(),
                        russianCitiesChoose.getButtonSaintP(),
                        russianCitiesChoose.getButtonKazan(),
                        "Питера нет в списке",
                        "Казани нет в списке"
                },
                {
                        countriesPage.getSelectUkraine(),
                        ukranianCitiesChoose.getButtonKiev(),
                        null,
                        "Киева нет в списке",
                        null
                }
        };
    }

    @Owner("Kudayeu S.")
    @TmsLink("5630752")
    @Test(description = "Краткое описание теста/проверки", dataProvider = "dataTest")
    public void contestOfCities(By country, By firstChoose, By secondChoose, String firstMessage, String secondMessage) {

        if (secondChoose != null) {
            driver.findElement(country).click();
            Assert.assertTrue(driver.findElement(firstChoose).isDisplayed(), firstMessage);
            Assert.assertTrue(driver.findElement(secondChoose).isDisplayed(), secondMessage);
            driver.findElement(locationchoose.getBackButton()).click();
        } else {
            driver.findElement(countriesPage.getSelectUkraine()).click();
            Assert.assertTrue(driver.findElement(firstChoose).isDisplayed(), firstMessage);
        }
    }
}