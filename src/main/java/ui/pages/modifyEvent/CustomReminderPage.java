package ui.pages.modifyEvent;

import lombok.Getter;
import org.openqa.selenium.By;
@Getter
public class CustomReminderPage {
    private final By popUpWindow = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout");
    private final By inputTime = By.id("com.andersenlab.meeting_room.debug:id/user_custom_time_edit_text");
}
