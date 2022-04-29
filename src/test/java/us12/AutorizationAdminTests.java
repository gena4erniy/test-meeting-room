package us12;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.AuthorizationPage;
import ui.pages.LocationChoose;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static ui.constants.Constant.ValidCredo.*;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")

public class AutorizationAdminTests {

    private AndroidDriver<AndroidElement> driver;
    private AuthorizationPage authorizationPage;
    private LocationChoose locationchoose;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        driver = capabilities();
        authorizationPage = new AuthorizationPage();
        locationchoose = new LocationChoose();
    }

    @Owner("Sirozh E.")
    @TmsLink("5629375")
    @Test
    public void checkEmailAdmin() {
        driver.findElement(authorizationPage.getEmailInput()).sendKeys("n.ermakov@andersenlab.com");
        Assert.assertFalse(driver.findElement(authorizationPage.getButtonLogin()).isEnabled(),"Element Login isn't active");
    }

    @Owner("Sirozh E.")
    @TmsLink("5629375")
    @Test(description = "Краткое описание теста/проверки")
    public void authorizationAdmin() {
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL_ADMIN);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS_ADMIN);
        Assert.assertTrue(driver.findElement(authorizationPage.getButtonLogin()).isEnabled(),"Element Login isn't active");
        driver.findElement(authorizationPage.getButtonLogin()).click();
    }
}

