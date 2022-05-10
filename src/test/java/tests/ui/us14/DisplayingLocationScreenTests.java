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
    @Test(description = "Pay attention on the Select location screen , Tap on Cascading menu and pay attention on result , \\n\" +" +
            "Tap on any country (ex: Ukraine) and pay attention on result")
    public void checkLocationChoosePage() {
        driver.findElement(locationchoose.getSelectButton()).click();
        driver.findElement(countriesPage.getSelectUkraine()).click();
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getNextButton()).getText().equals("NEXT"));
        Assert.assertTrue(driver.findElement(locationchoose.getCityName()).getText().equals("Kiev"));
        driver.findElement(locationchoose.getSelectButton()).click();
        Assert.assertEquals(driver.findElement(countriesPage.getSelectUkraine()).getText(), "Ukraine");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectRussia()).getText(), "Russia");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectBelarus()).getText(), "Belarus");
        Assert.assertEquals(driver.findElement(countriesPage.getLocationText()).getText(), "Location");
        Assert.assertTrue(driver.findElement(countriesPage.getBackButton()).isEnabled());
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonGomel()).getText(), "Gomel");
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonMinsk()).getText(), "Minsk");
        Assert.assertTrue(driver.findElement(belarusCitiesChoose.getButtonBack()).isEnabled());

    }


}
