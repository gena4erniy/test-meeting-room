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
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")

public class AuthEmptyFieldsTests {
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
    @TmsLink("5628125")
    @Test(description = "User authorization using empty fields")
    public void authorizationNull() {
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertFalse(driver.findElement(authorizationPage.getButtonLogin()).isEnabled(), "test failed");
    }
}
