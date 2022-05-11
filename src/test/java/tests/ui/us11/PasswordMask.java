package tests.ui.us11;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.pages.AuthorizationPage;

import java.net.MalformedURLException;

import static ui.constants.Constant.ValidCredo.VALID_PASS;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")

public class PasswordMask {
    private AndroidDriver<AndroidElement> driver;
    private AuthorizationPage authorizationPage;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        driver = capabilities();
        authorizationPage = new AuthorizationPage();
    }

    @AfterClass
    public void closeDriver() {driver.quit();}

    @Owner("Kudayeu S.")
    @TmsLink("5628570")
    @Test(description = "Password mask switch")
    public void passMask(){
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS);
        Assert.assertTrue(driver.findElement(authorizationPage.getEyeIconcross()).isDisplayed(), "Hover doesn't work");
        Assert.assertTrue(driver.findElement(authorizationPage.getHoverPass()).isDisplayed(), "Hover doesn't work");
        driver.findElement(authorizationPage.getEyeIcon()).click();
        Assert.assertTrue(driver.findElement(authorizationPage.getEyeIconNocross()).isDisplayed(), "Hover doesn't work");
        Assert.assertTrue(driver.findElement(authorizationPage.getNoHoverPass()).isDisplayed(), "Hover doesn't work");
    }
}
