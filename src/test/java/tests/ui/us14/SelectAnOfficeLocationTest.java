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
public class SelectAnOfficeLocationTest extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;

    public SelectAnOfficeLocationTest() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630751")
    @Test(description = "verify that the location choice is saved on the User's device.")
    public void selectAnOfficeLocationTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertTrue(driver.findElement(belarusCitiesChoose.getButtonGomel()).isDisplayed() && driver.findElement(belarusCitiesChoose.getButtonMinsk()).isDisplayed(), "The List of cities page for Belarus is not displayed List:Minsk, Gomel");
        driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getMySpaceTitle()).isDisplayed(), "My space page is not displayed.");
        driver.findElement(mySpacePage.getSettingsButton()).click();
        driver.findElement(mySpacePage.getLocationSettings()).click();
        Assert.assertEquals(driver.findElement(locationchoose.getCityName()).getText(), "Gomel", "The location choice is not saved on the User's device.");
    }
}
