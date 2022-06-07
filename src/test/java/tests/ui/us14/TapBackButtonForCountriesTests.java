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
public class TapBackButtonForCountriesTests extends BaseTest {
    private LocationChoose locationchoose;
    private CountriesPage countriesPage;

    public TapBackButtonForCountriesTests() {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        countriesPage = new CountriesPage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630744")
    @Test(description = "Verification that the back button works")
    public void tapBackButtonOnTheLocationTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getCountryText()).isDisplayed(), "The countrie is not displayed");
        driver.findElement(countriesPage.getBackButton()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectButton()).isDisplayed(), "The  location page is not displayed");
    }
}