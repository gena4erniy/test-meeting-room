package ui.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static ui.constants.Constant.Capabilities.*;
import static ui.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static ui.constants.Constant.Urls.DRIVER_URL;

public class BasePage {
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, NAME_DEVICE);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, NAME_AUTOMATION);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(DRIVER_URL), cap);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        return driver;
    }
}
