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
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.activateApp(APP_PACKAGE);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.resetApp();
            driver.terminateApp(APP_PACKAGE);
        }
    }
}
