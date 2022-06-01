package tests.ui.us11;


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

import static ui.constants.Constant.ValidCredoSpace.VALID_MAIL_SPACE;
import static ui.constants.Constant.ValidCredoSpace.VALID_PASS_SPACE;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")

public class AutorizationValidSpaceTests {
    private AndroidDriver<AndroidElement> driver;
    private AuthorizationPage authorizationPage;
    private LocationChoose locationchoose;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        driver = capabilities();
        authorizationPage = new AuthorizationPage();
        locationchoose = new LocationChoose();
    }
    @AfterClass
    public void closeDriver() {driver.quit();}

    @Owner("Kudayeu S.")
    @TmsLink("5629334")
    @Test(description = "User authorization using valid data with space in the middle")
    public void authorizationSpace(){
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL_SPACE);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS_SPACE);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(authorizationPage.getAlert()).isDisplayed(), "test failed");
    }
}
