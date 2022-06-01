package ui.pages.modifyEvent;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ModifyReminderPage {

    private final By chekButNever = By.xpath("//android.view.ViewGroup[1]/android.widget.RadioButton");
    private final By listReminder = By.xpath("//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView");
    private final By customButton = By.xpath("//android.view.ViewGroup[8]/android.widget.RadioButton");

}

