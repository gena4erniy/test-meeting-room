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
public class DisplayingLocationScreenTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;


    public DisplayingLocationScreenTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();


    }

    @Owner("Sirozh E.")
    @TmsLink("5629437")
    @Test(description = "The Select location matches to mockup. (Kiev by default?)")
    public void checkLocationChoosePage() {
        Assert.assertTrue(driver.findElement(locationchoose.getNextButton()).getText().equals("NEXT"));
        Assert.assertTrue(driver.findElement(locationchoose.getCityName()).getText().equals("Kiev"));

    }

    @Owner("Sirozh E.")
    @TmsLink("5629437")
    @Test(description = "The List of countries page matches to mockup.")
    public void checkCountryPage() {
        driver.findElement(locationchoose.getSelectButton()).click();
        Assert.assertEquals(driver.findElement(countriesPage.getSelectUkraine()).getText(), "Ukraine");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectRussia()).getText(), "Russia");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectBelarus()).getText(), "Belarus");
        Assert.assertEquals(driver.findElement(countriesPage.getLocationText()).getText(), "Location");

    }
    @Owner("Sirozh E.")
    @TmsLink("5629437")
    @Test(description = "The List of cities page matches to mockup.")
    public void checkBelarusCityChoose() {
        driver.findElement(locationchoose.getSelectButton()).click();
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonGomel()).getText(), "Gomel");
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonMinsk()).getText(), "Minsk");
        Assert.assertTrue(driver.findElement(belarusCitiesChoose.getButtonBack()).isEnabled());

    }

}
