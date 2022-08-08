package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UkraineCityScreen extends BaseScreen {

    @FindBy(id = "city_text")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Kiev']")
    private WebElement kievField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Kiev']//following-sibling::*[@index=1]")
    private WebElement kievRadioButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Kiev']//following-sibling::*[@index=2]")
    private WebElement lineUnderKievField;

    public String getTitle() {
        return title.getText();
    }

    public void tapKievRadioButton() {
        kievRadioButton.click();
    }
}
