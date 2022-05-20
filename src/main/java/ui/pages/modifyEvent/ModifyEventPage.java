package ui.pages.modifyEvent;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ModifyEventPage {
    private final By reminder = By.id("set_reminder");
    private final By reminder5Min= By.xpath("//android.view.ViewGroup[3]/android.widget.RadioButton");
    private final By save = By.id("button_save_toolbar");
    private final By pageTitle = By.xpath("//android.widget.TextView[@text = 'Modify event']");
    private final By buttonReminder = By.id("com.andersenlab.meeting_room.debug:id/reminder_left_time");
    private final By timePickerStart = By.id("com.andersenlab.meeting_room.debug:id/modify_start_time_picker");
    private final By timePickerEnd = By.id("com.andersenlab.meeting_room.debug:id/modify_end_time_picker");
    private final By deleteEventButton = By.id("com.andersenlab.meeting_room.debug:id/tv_delete_event");

}
