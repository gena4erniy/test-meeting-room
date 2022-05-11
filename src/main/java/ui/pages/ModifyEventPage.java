package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ModifyEventPage {
    private final By reminder = By.id("set_reminder");
    private final By reminder5Min= By.xpath("//android.view.ViewGroup[3]/android.widget.RadioButton");
    private final By save = By.id("button_save_toolbar");
    private final By pageTitle = By.xpath("//android.widget.TextView[@text = 'Modify event']");
}
