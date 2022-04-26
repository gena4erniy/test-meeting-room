package ui.pages;

import org.openqa.selenium.By;

public class BelarusCitiesChoose {
    private final By buttonMinsk = By.xpath("//android.widget.TextView[@text = 'Minsk']");
    private final By buttonGomel = By.xpath("//android.widget.TextView[@text = 'Gomel']");

    public By getButtonGomel() {
        return buttonGomel;
    }

    public By getButtonMinsk() {
        return buttonMinsk;
    }
}