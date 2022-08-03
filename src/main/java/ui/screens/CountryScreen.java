package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CountryScreen extends BaseScreen {

    @FindBy(id = "arrow_back_location_fragment")
    private WebElement backButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Location']")
    private WebElement locationText;

    @FindBy(id = "country_text")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Ukraine']")
    private WebElement ukraineField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Ukraine']//following-sibling::*[@index=1]")
    private WebElement ukraineSelectButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Ukraine']//following-sibling::*[@index=2]")
    private WebElement lineUnderUkraineField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Russia']")
    private WebElement russiaField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Russia']//following-sibling::*[@index=1]")
    private WebElement russiaSelectButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Russia']//following-sibling::*[@index=2]")
    private WebElement lineUnderRussiaField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Belarus']")
    private WebElement belarusField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Belarus']//following-sibling::*[@index=1]")
    private WebElement belarusSelectButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Belarus']//following-sibling::*[@index=2]")
    private WebElement lineUnderBelarusField;

    public void tapBackButton() {
        backButton.click();
    }

    public String getTitle() {
        return title.getText();
    }

    public void tapUkraineSelectButton() {
        ukraineSelectButton.click();
    }

    public void tapRussiaSelectButton() {
        russiaSelectButton.click();
    }

    public void tapBelarusSelectButton() {
        belarusSelectButton.click();
    }
}
