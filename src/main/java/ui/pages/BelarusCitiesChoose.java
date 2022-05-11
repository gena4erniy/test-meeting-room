package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class BelarusCitiesChoose {
    private final By buttonMinsk = By.xpath("//android.widget.TextView[@text = 'Minsk']");
    private final By buttonGomel = By.xpath("//android.widget.TextView[@text = 'Gomel']");
}