package ui.pages;

import org.openqa.selenium.By;

public class AuthorizationPage {
    private final By logoImg = By.xpath("//android.widget.ImageView");
    private final By textOffice = By.xpath("//android.widget.TextView[@text = 'Office Assistant']");
    private final By textMundle = By.xpath("//android.widget.TextView[@text = 'Mundane office tasks made simple :)']");
    private final By emailInput = By.xpath("//android.widget.EditText[@text = 'E-mail']");
    private final By passwordInput = By.xpath("//android.widget.EditText[@text = 'Password']");
    private final By eyeIcon = By.xpath("//android.widget.ToggleButton");
    private final By buttonLogin = By.xpath("//android.widget.TextView[@text = 'LOG IN']");

    public By getLogoImg() {
        return logoImg;
    }

    public By getTextOffice() {
        return textOffice;
    }

    public By getTextMundle() {
        return textMundle;
    }

    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getEyeIcon() {
        return eyeIcon;
    }

    public By getButtonLogin() {
        return buttonLogin;
    }
}