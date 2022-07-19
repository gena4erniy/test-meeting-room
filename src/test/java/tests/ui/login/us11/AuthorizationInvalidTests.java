package tests.ui.login.us11;

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

import java.net.MalformedURLException;

import static ui.constants.Constant.ValidCredo.VALID_PASS;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")
public class AuthorizationInvalidTests {
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
    @TmsLink("5628121")
    @Test(description = "User authorization using missigned \"@\" e-mail")
    public void authorizationMissingEmail() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys("numb3andersenlab.com");
        Assert.assertFalse(driver.findElement(authorizationPage.getButtonLogin()).isEnabled());
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS);
        Assert.assertTrue(driver.findElement(authorizationPage.getButtonLogin()).isEnabled());
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(authorizationPage.getAlert()).isDisplayed());
        Assert.assertEquals(driver.findElement(authorizationPage.getAlert()).getText(), "Incorrect e-mail or password!");
    }
}
