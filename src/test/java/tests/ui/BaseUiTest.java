package tests.ui;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static ui.constants.Constant.Capabilities.APP_PACKAGE;

public abstract class BaseUiTest {

    protected AppiumDriver<WebElement> driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = DriverManager.getDriver();
        driver.activateApp(APP_PACKAGE);
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.terminateApp(APP_PACKAGE);
        }
    }
}
