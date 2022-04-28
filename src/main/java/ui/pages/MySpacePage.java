package ui.pages;

import org.openqa.selenium.By;

public class MySpacePage {
    private final By mySpaceTitle = By.xpath("//android.widget.TextView[@text = 'My space']");
    private final By settingsButton = By.id("mrtoolbar_icon");
    private final By locationSettings = By.id("popup_local_settings");

    public By getMySpaceTitle() {
        return mySpaceTitle;
    }

    public By getSettingsButton() {
        return settingsButton;
    }

    public By getLocationSettings() {
        return locationSettings;
    }
}
