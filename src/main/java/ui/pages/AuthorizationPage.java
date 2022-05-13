package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
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
}
