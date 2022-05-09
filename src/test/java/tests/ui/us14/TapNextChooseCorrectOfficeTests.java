package tests.ui.us14;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

public class TapNextChooseCorrectOfficeTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;



    public TapNextChooseCorrectOfficeTests() throws MalformedURLException {
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

    @Owner("Sirozh E.")
    @TmsLink("5630209")
    @Test(description = "The List of countries page is displayed")
    public void checkListOfCountries() {
        Assert.assertEquals(driver.findElement(countriesPage.getSelectUkraine()).getText(), "Ukraine");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectRussia()).getText(), "Russia");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectBelarus()).getText(), "Belarus");

    }
}
