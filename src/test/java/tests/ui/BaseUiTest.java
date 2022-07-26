package tests.ui;

import driver.manager.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import static ui.constants.Constant.Capabilities.APP_PACKAGE;

public abstract class BaseUiTest {

    protected AndroidDriver<AndroidElement> driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = DriverManager.getDriver();
        driver.activateApp(APP_PACKAGE);
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.terminateApp(APP_PACKAGE);
        }
    }
}
