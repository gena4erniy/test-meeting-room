package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationScreen extends BaseScreen {

    @FindBy(id = "iv_app_logo_location_fragment")
    private WebElement logoImg;

    @FindBy(id = "tv_select_location_fragment")
    private WebElement tittle;

    public String getTittle() {
        return tittle.getText();
    }
}
