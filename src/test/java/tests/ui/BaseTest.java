package tests.ui;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import ui.pages.*;

import java.net.MalformedURLException;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;
import static ui.pages.BasePage.capabilities;

public class BaseTest {
    private AuthorizationPage authorizationPage = new AuthorizationPage();
    private LocationChoose locationchoose = new LocationChoose();
    public AndroidDriver<AndroidElement> driver = capabilities();

    public BaseTest() throws MalformedURLException {
    }

    public void authorization(){
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "Login is not succeed");
    }
}
