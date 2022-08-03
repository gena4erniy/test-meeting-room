package steps;

import io.qameta.allure.Step;
import ui.screens.SettingsMenuScreen;

public class SettingsMenuStep extends BaseStep {

    private SettingsMenuScreen settingsMenuScreen;

    @Step("On settings menu screen")
    public void onSettingsMenuScreen() {
        settingsMenuScreen = new SettingsMenuScreen();
    }

    @Step("Tap log out button")
    public void tapLogOutButton() {
        settingsMenuScreen.tapLogOutButton();
    }
}
