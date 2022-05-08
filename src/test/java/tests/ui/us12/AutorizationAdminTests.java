package tests.ui.us12;

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
import tests.ui.BaseTest;
import ui.pages.AuthorizationPage;
import ui.pages.LocationChoose;

import java.net.MalformedURLException;

import static ui.constants.Constant.ValidCredo.*;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")

public class AutorizationAdminTests extends BaseTest {

    private AuthorizationPage authorizationPage = new AuthorizationPage();
    private LocationChoose locationchoose = new LocationChoose();

    public AutorizationAdminTests() throws MalformedURLException {
    }


    @Owner("Sirozh E.")
    @TmsLink("5639663")
    @Test(description = "Data is displayed in the field, \"Log in\" button is active")
    public void checkAuthorizationAdmin() throws MalformedURLException {
        driver = capabilities();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL_ADMIN);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS_ADMIN);
        Assert.assertTrue(driver.findElement(authorizationPage.getButtonLogin()).isEnabled(), "Element Login isn't active");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}

