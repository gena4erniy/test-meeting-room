package tests.ui.us14;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

@Epic("Login")
@Feature("US 1.4")
public class DoubleTapOnNextButtonTests extends BaseTest {
    private LocationChoose locationchoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;

    public DoubleTapOnNextButtonTests() {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5632927")
    @Test(description = "Verify that double tap leads to saving the location", enabled = false)
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
        Assert.assertTrue(driver.findElement(mySpacePage.getMySpaceTitle()).isDisplayed(), "My space page is not displayed.");
    }
}
