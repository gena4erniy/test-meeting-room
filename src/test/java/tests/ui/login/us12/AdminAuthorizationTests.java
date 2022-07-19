package tests.ui.login.us12;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.AuthorizationPage;
import ui.pages.LocationChoose;

import java.net.MalformedURLException;

import static ui.constants.Constant.ValidCredo.VALID_MAIL_ADMIN;
import static ui.constants.Constant.ValidCredo.VALID_PASS_ADMIN;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.2")
public class AdminAuthorizationTests {
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
    @TmsLink("C5629375")
    @Test(description = "Administrator authorization using valid data")
    public void authorizationAdminPass() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL_ADMIN);
        Assert.assertFalse(driver.findElement(authorizationPage.getButtonLogin()).isEnabled());
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS_ADMIN);
        Assert.assertTrue(driver.findElement(authorizationPage.getButtonLogin()).isEnabled());
        driver.findElement(authorizationPage.getButtonLogin()).click();
        LocationChoose locationChoose = new LocationChoose();
        Assert.assertEquals(driver.findElement(locationChoose.getSelectLoc()).getText(), "Select your location");
    }
}
