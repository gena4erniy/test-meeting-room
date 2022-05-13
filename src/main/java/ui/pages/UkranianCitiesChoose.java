package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class UkranianCitiesChoose {
    private final By buttonKiev = By.xpath("//android.widget.TextView[@text = 'Kiev']");
}
