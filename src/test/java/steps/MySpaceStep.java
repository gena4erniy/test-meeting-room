package steps;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import ui.screens.MySpaceScreen;
import verification.VerifySoft;

import static ui.constants.Constant.Capabilities.APP_PACKAGE;

public class MySpaceStep extends BaseStep {

    MySpaceScreen mySpaceScreen = new MySpaceScreen();

    @Step("On my space screen")
    public void onMySpaceScreen() {
        mySpaceScreen = new MySpaceScreen();
    }

    @Step("Tap settings button")
    public void tapSettingsButton() {
        mySpaceScreen.tapSettingsButton();
    }

    @Step("Get title")
    public String getTitle() {
        return mySpaceScreen.getTitle();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getTitle(), title, message);
    }

    @Step("Close app")
    public void closeApp(AppiumDriver<WebElement> driver) {
        driver.terminateApp(APP_PACKAGE);
    }

    @Step("Launch app")
    public void launchApp(AppiumDriver<WebElement> driver) {
        driver.activateApp(APP_PACKAGE);
    }
}
