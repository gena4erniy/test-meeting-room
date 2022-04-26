package ui.pages;

import org.openqa.selenium.By;

public class UkranianCitiesChoose {
    private final By buttonKiev = By.xpath("//android.widget.TextView[@text = 'Kiev']");

    public By getButtonKiev() {
        return buttonKiev;
    }
}