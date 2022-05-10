package tests.ui;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import ui.pages.*;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;
import static ui.pages.BasePage.capabilities;

public class BaseTest {
    private AuthorizationPage authorizationPage = new AuthorizationPage();
    private LocationChoose locationchoose = new LocationChoose();
    private MySpacePage mySpacePage = new MySpacePage();
    private ModifyEventPage modifyEventPage = new ModifyEventPage();
    public AndroidDriver<AndroidElement> driver;

    public BaseTest() {
    }

    @SneakyThrows
    public void authorization() {
        driver = capabilities();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "Login is not succeed");
    }

    public void setTimeToReminder() {
        driver.findElement(mySpacePage.getEventCard()).click();
        driver.findElement(modifyEventPage.getReminder()).click();
        driver.findElement(modifyEventPage.getReminder5Min()).click();
        driver.findElement(modifyEventPage.getSave()).click();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
