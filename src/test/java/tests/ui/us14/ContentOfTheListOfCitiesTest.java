package tests.ui.us14;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

public class ContentOfTheListOfCitiesTest extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;

    public ContentOfTheListOfCitiesTest() throws MalformedURLException {
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

    @Owner("Vaskovich K.")
    @TmsLink("5630752")
    @Test(description = "Verify that the list of cities page for different countries is displayed")
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
}
