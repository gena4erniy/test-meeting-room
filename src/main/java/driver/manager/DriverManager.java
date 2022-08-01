package driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static ui.constants.Constant.Capabilities.*;
import static ui.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static ui.constants.Constant.Urls.DRIVER_URL;

public class DriverManager {

    private static AppiumDriver<WebElement> driver;

    private DriverManager() {
    }

    private static URL createUrl() {
        try {
            return new URL(DRIVER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("Can't create URL with this parameter: " + DRIVER_URL);
        }
    }

    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, NAME_DEVICE);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, NAME_AUTOMATION);
        return cap;
    }

    //    private static AndroidDriver<AndroidElement> createDriver() {
    private static AppiumDriver<WebElement> createDriver() {
        driver = new AndroidDriver<>(createUrl(), getCapabilities());
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    //    public static AndroidDriver<AndroidElement> getDriver() {
    public static AppiumDriver<WebElement> getDriver() {
        if (driver == null) {
            try {
                driver = createDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
