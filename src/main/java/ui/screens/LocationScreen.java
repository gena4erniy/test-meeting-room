package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationScreen extends BaseScreen {

    @FindBy(id = "iv_app_logo_location_fragment")
    private WebElement logoImg;

    @FindBy(id = "tv_select_location_fragment")
    private WebElement title;

    @FindBy(id = "tv_city_select_text")
    private WebElement cityField;

    @FindBy(id = "iv_select_layoutLocation_fragment")
    private WebElement selectLocationButton;

    @FindBy(id = "view_border")
    private WebElement lineUnderCityField;

    @FindBy(id = "log_in_text_main_activity")
    private WebElement nextButton;

    public String getTitle() {
        return title.getText();
    }

    public void tapSelectLocationButton() {
        selectLocationButton.click();
    }

    public void tapNextButton() {
        nextButton.click();
    }
}
