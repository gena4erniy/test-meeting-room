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

@Epic("Login")
@Feature("US 1.4")
public class TapCountryButtonForCitiesTests extends BaseTest {
    private LocationChoose locationchoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private CountriesPage countriesPage;

    public TapCountryButtonForCitiesTests(){
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        countriesPage = new CountriesPage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630745")
    @Test(description = "Verification that tap on Country button lead to the list of countries")
    public void tapCountryButtonOnTheLocationTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getSelectUkraine()).click();
        Assert.assertTrue(driver.findElement(ukranianCitiesChoose.getButtonKiev()).isDisplayed(), "The List of cities page for selected country is not displayed");
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectButton()).isDisplayed(), "The  location page is not displayed");
    }
}
