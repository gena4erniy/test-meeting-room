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
public class ContentOfTheListOfCountriesTest extends BaseTest {
    private LocationChoose locationchoose;
    private CountriesPage countriesPage;

    public ContentOfTheListOfCountriesTest(){
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        countriesPage = new CountriesPage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5630753")
    @Test(description = "Verify that the List: Ukraine, Russia, Belarus is displayed")
    public void contentsOfTheListOfCountriesTest() {
        Assert.assertTrue(driver.findElement(countriesPage.getSelectRussia()).isDisplayed() &&
                driver.findElement(countriesPage.getSelectBelarus()).isDisplayed() &&
                driver.findElement(countriesPage.getSelectUkraine()).isDisplayed(), "The countrie is not displayed");
    }
}
