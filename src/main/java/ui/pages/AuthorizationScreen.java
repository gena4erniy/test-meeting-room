package ui.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AuthorizationScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'E-mail']")
    private AndroidElement emailField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Password']")
    private AndroidElement passwordField;
    
    @AndroidFindBy(id = "com.andersenlab.meeting_room.debug:id/log_in_button_main_activity")
    private AndroidElement logInButton;

    @AndroidFindBy(id = "com.andersenlab.meeting_room.debug:id/error_text_custom_edit_text")
    private AndroidElement errorField;

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
