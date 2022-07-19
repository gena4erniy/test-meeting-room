package tests.ui.my.space;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.*;

import java.net.MalformedURLException;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;
import static ui.pages.BasePage.capabilities;

@Epic("My Space")
public class LogOutTests {
    private AndroidDriver<AndroidElement> driver;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        driver = capabilities();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Owner(value = "Tatarina T.")
    @TmsLink("5628129")
    @Test(description = "Manually log out from the application landing page")
    public void logOut() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        LocationChoose locationchoose = new LocationChoose();
        driver.findElement(locationchoose.getSelectButton()).click();
        CountriesPage countriesPage = new CountriesPage();
        driver.findElement(countriesPage.getSelectUkraine()).click();
        UkranianCitiesChoose ukranianCitiesChoose = new UkranianCitiesChoose();
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        driver.findElement(locationchoose.getNextButton()).click();
        MySpacePage mySpacePage = new MySpacePage();
        Assert.assertEquals(driver.findElement(mySpacePage.getMySpaceTitle()).getText(), "My space");
        driver.findElement(mySpacePage.getSettingsButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getPopupLogOut()).isDisplayed());
        driver.findElement(mySpacePage.getPopupLogOut()).click();
        authorizationPage = new AuthorizationPage();
        Assert.assertEquals(driver.findElement(authorizationPage.getTextOffice()).getText(), "Office Assistant");
    }
}

