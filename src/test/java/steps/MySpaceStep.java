package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import ui.screens.MySpaceScreen;
import verification.VerifySoft;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;
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

    @Step("Tap upcoming tab")
    public void tapUpcomingTab() {
        mySpaceScreen.tapUpcomingTab();
    }

    @Step("Tap history tab")
    public void tapHistoryTab() {
        mySpaceScreen.tapHistoryTab();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getTitle(), title, message);
    }

    @Step("Check upcoming tab activity")
    public void checkUpcomingTabActivity(Boolean activity, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getUpcomingTabActivity(), activity, message);
    }

    @Step("Check upcoming tab visibility")
    public void checkUpcomingTabVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getUpcomingTabVisibility(), visibility, message);
    }

    @Step("Check history tab activity")
    public void checkHistoryTabActivity(Boolean activity, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getHistoryTabActivity(), activity, message);
    }

    @Step("Check history tab visibility")
    public void checkHistoryTabVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getHistoryTabVisibility(), visibility, message);
    }

    @Step("Check all event cards visibility")
    public void checkAllEventCardsVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getAllEventCardsVisibility(), visibility, message);
    }

    @Step("Check event title visibility")
    public void checkEventTitleVisibility(int index, Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getEventTitleVisibility(index), visibility, message);
    }

    @Step("Check event planned time visibility")
    public void checkEventPlannedTimeVisibility(int index, Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getEventPlannedTimeVisibility(index), visibility, message);
    }

    @Step("Check event planned date visibility")
    public void checkEventPlannedDateVisibility(int index, Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getEventPlannedDateVisibility(index), visibility, message);
    }

    @Step("Check event room visibility")
    public void checkEventRoomVisibility(int index, Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(mySpaceScreen.getEventRoomVisibility(index), visibility, message);
    }

    @Step("Horizontal {direction} swipe")
    public void horizontalSwipe(String direction, AppiumDriver<WebElement> driver) {
        mySpaceScreen.horizontalSwipe(direction, driver);
    }

    @Step("Tap event card")
    public void tapEventCard(int index) {
        mySpaceScreen.tapEventCard(index);
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
