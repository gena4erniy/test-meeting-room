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
    private MySpacePage mySpacePage;

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
        mySpacePage = new MySpacePage();
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

    @Owner("Vaskovich K.")
    @TmsLink("5630744")
    @Test
    public void tapBackButtonOnTheLocationTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getBackButton()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectButton()).isDisplayed(), "The  location page is not displayed");
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630745")
    @Test
    public void tapCountryButtonOnTheLocationTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectUkraine()).click();
        Assert.assertTrue(driver.findElement(ukranianCitiesChoose.getButtonKiev()).isDisplayed(), "The List of cities page for selected country is not displayed");
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectButton()).isDisplayed(), "The  location page is not displayed");
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630752")
    @Test()
    public void contentsOfTheListOfCitiesTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertTrue(driver.findElement(belarusCitiesChoose.getButtonGomel()).isDisplayed() && driver.findElement(belarusCitiesChoose.getButtonMinsk()).isDisplayed(), "The List of cities page for Belarus is not displayed List:Minsk, Gomel");
        driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
        driver.findElement(locationchoose.getSelectButton()).click();

        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectUkraine()).click();
        Assert.assertTrue(driver.findElement(ukranianCitiesChoose.getButtonKiev()).isDisplayed(), "The List of cities  page for Ukraine is displayed List: Kyiv");
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        driver.findElement(locationchoose.getSelectButton()).click();

        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectRussia()).click();
        Assert.assertTrue(driver.findElement(russianCitiesChoose.getButtonSaintP()).isDisplayed() && driver.findElement(russianCitiesChoose.getButtonKazan()).isDisplayed(), "The List of cities page for Russia is displayed List: Saint Petersburg, Kazan)");
        driver.findElement(russianCitiesChoose.getButtonSaintP()).click();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5632927")
    @Test
    @Ignore("Fix double type")
    public void doubleTapOnNextButtonTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectRussia()).click();
        Assert.assertTrue(driver.findElement(russianCitiesChoose.getButtonSaintP()).isDisplayed() && driver.findElement(russianCitiesChoose.getButtonKazan()).isDisplayed(), "The List of cities page for Russia is displayed List: Saint Petersburg, Kazan)");
        driver.findElement(russianCitiesChoose.getButtonSaintP()).click();
        Assert.assertEquals(driver.findElement(locationchoose.getCityName()).getText(), "Saint Petersburg");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locationchoose.getNextButton()));
        action.doubleClick();
        action.perform();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630751")
    @Test
    public void selectAnOfficeLocationTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertTrue(driver.findElement(belarusCitiesChoose.getButtonGomel()).isDisplayed() && driver.findElement(belarusCitiesChoose.getButtonMinsk()).isDisplayed(), "The List of cities page for Belarus is not displayed List:Minsk, Gomel");
        driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getMySpaceTitle()).isDisplayed(),"My space page is not displayed.");
        driver.findElement(mySpacePage.getSettingsButton()).click();
        driver.findElement(mySpacePage.getLocationSettings()).click();
        Assert.assertEquals(driver.findElement(locationchoose.getCityName()).getText(), "Gomel","The location choice is not saved on the User's device.");
    }
}