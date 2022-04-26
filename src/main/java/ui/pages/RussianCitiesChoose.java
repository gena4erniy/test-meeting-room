package ui.pages;

import org.openqa.selenium.By;

public class RussianCitiesChoose {
    private final By buttonSaintP = By.xpath("//android.widget.TextView[@text = 'Saint Petersburg']");
    private final By buttonKazan = By.xpath("//android.widget.TextView[@text = 'Kazan']");
    private final By backButton = By.id("arrow_back_location_fragment");

    public By getBackButton() {
        return backButton;
    }

    public By getButtonKazan() {
        return buttonKazan;
    }

    public By getButtonSaintP() {
        return buttonSaintP;
    }
}