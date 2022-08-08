package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsMenuScreen extends BaseScreen {

    @FindBy(id = "popup_local_settings")
    private WebElement locationSettings;

    @FindBy(id = "popup_dark_theme")
    private WebElement darkTheme;

    @FindBy(id = "popup_switch_dark_theme")
    private WebElement darkThemeSwitchButton;

    @FindBy(id = "popup_view_divider")
    private WebElement lineUnderDarkTheme;

    @FindBy(id = "popup_log_out")
    private WebElement logOutButton;

    public void tapLogOutButton() {
        logOutButton.click();
    }
}
