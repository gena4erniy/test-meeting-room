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
    private final By alert = By.xpath("//android.widget.TextView[@text = 'Incorrect e-mail or password!']");

    private final By hoverPass = By.xpath("//android.widget.EditText[@text ='••••']");
    private final By noHoverPass = By.xpath("//android.widget.EditText[@text ='1111']");
    private final By eyeIconNocross = By.xpath("//android.widget.ToggleButton[@checked = 'false']");
    private final By eyeIconcross = By.xpath("//android.widget.ToggleButton[@checked = 'true']");
    private final By maxMail = By.xpath("//android.widget.EditText[@text = '1234567890123456789012345678901234567890123456789012345678901234']");
    private final By MoremaxMail = By.xpath("//android.widget.EditText[@text = '12345678901234567890123456789012345678901234567890123456789012345']");

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
    public By getAlert() { return alert;}
    public By getHoverPass() {return hoverPass;}
    public By getNoHoverPass() {return noHoverPass;}
    public By getEyeIconNocross() {return eyeIconNocross;}
    public By getEyeIconcross() {return eyeIconcross;}
    public By getMaxMail() {return maxMail;}
    public By getMoremaxMail() {return MoremaxMail;}


}