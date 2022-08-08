package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BelarusCityScreen extends BaseScreen {

    @FindBy(id = "city_text")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Minsk']")
    private WebElement minskField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Minsk']//following-sibling::*[@index=1]")
    private WebElement minskRadioButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Minsk']//following-sibling::*[@index=2]")
    private WebElement lineUnderMinskField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Gomel']")
    private WebElement gomelField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Gomel']//following-sibling::*[@index=1]")
    private WebElement gomelRadioButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Gomel']//following-sibling::*[@index=2]")
    private WebElement lineUnderGomelField;

    public String getTitle() {
        return title.getText();
    }

    public void tapMinskRadioButton() {
        minskRadioButton.click();
    }

    public void tapGomelRadioButton() {
        gomelRadioButton.click();
    }
}
