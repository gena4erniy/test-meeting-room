package tests.ui.us14;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

@Epic("Login")
@Feature("US 1.4")
public class WorkBackButtonTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;


    public WorkBackButtonTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getSelectButton()).click();

    }

    @Owner("Sirozh E.")
    @TmsLink("5630744")
    @Test(description = "The countrie is displayed")
    public void checkCountry() {
        Assert.assertEquals(driver.findElement(countriesPage.getSelectUkraine()).getText(), "Ukraine");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectRussia()).getText(), "Russia");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectBelarus()).getText(), "Belarus");

    }

    @Owner("Sirozh E.")
    @TmsLink("5630744")
    @Test(description = "Tap on Back button, Select your location page is displayed")
    public void checkWorkBackButton() {
        driver.findElement(countriesPage.getBackButton()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed());
    }
}
