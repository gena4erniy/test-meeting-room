package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationScreen extends BaseScreen {

    @FindBy(id = "app_logo_login_fragment")
    private WebElement logoImg;

    @FindBy(id = "app_name_login_fragment")
    private WebElement tittle;

    @FindBy(id = "app_motto_login_fragment")
    private WebElement textUnderTittleElement;

    @FindBy(xpath = "//android.widget.EditText[@text='E-mail']")
    private WebElement emailField;

    @FindBy(xpath = "//android.widget.EditText[@text='E-mail']/following-sibling::*[@resource-id='com.andersenlab.meeting_room.debug:id/view_custom_edit_text']")
    private WebElement lineUnderEmailField;

    @FindBy(xpath = "//android.widget.EditText[@text='Password']")
    private WebElement passwordField;

    @FindBy(id = "toggle_button_custom_edit_text")
    private WebElement eyeButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Password']/following-sibling::*[@resource-id='com.andersenlab.meeting_room.debug:id/view_custom_edit_text']")
    private WebElement lineUnderPasswordField;

    @FindBy(id = "log_in_text_main_activity")
    private WebElement logInButton;

    @FindBy(id = "error_text_custom_edit_text")
    private WebElement errorField;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getErrorMessage() {
        return errorField.getText();
    }

    public boolean getLogInButtonActivity() {
        return logInButton.isEnabled();
    }

    public void tapOnLogInButton() {
        logInButton.click();
    }
}
