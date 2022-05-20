package ui.pages.modifyEvent;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DeleteEventPage {
    private final By deleteEventTitle = By.id("android:id/message");
    private final By deleteButton = By.id("android:id/button1");
}
