package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySpaceScreen extends BaseScreen {

    @FindBy(id = "mrtoolbar_title")
    private WebElement title;

    @FindBy(id = "mrtoolbar_icon")
    private WebElement settingsButton;

    public String getTitle() {
        return title.getText();
    }

    public void tapSettingsButton() {
        settingsButton.click();
    }
}
