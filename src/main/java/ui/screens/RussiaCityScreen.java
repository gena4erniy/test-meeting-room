package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RussiaCityScreen extends BaseScreen {

    @FindBy(id = "city_text")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Saint Petersburg']")
    private WebElement saintPetersburgField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Saint Petersburg']//following-sibling::*[@index=1]")
    private WebElement saintPetersburgRadioButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Saint Petersburg']//following-sibling::*[@index=2]")
    private WebElement lineUnderSaintPetersburgField;

    public String getTitle() {
        return title.getText();
    }

    public void tapSaintPetersburgRadioButton() {
        saintPetersburgRadioButton.click();
    }
}
