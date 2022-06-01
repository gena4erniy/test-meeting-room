package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class RoomsPage {
    // private final By roomsTitle = By.xpath("//android.widget.FrameLayout[@content-desc='Rooms']/android.widget.ImageView");
    private final By nextDate = By.id("com.andersenlab.meeting_room.debug:id/next");
    private final By previousDate = By.id("com.andersenlab.meeting_room.debug:id/previous");
    private final By choseDate = By.xpath("//android.widget.CheckedTextView[@content-desc='9']");
    private final By choseEvent = By.id("com.andersenlab.meeting_room.debug:id/eventView");
    private final By choseDate13 = By.xpath("//android.widget.CheckedTextView[@content-desc='13']");

    private final By eventCard = By.id("com.andersenlab.meeting_room.debug:id/event_card_upcoming_root");
    private final By previousButton = By.xpath("//android.widget.ImageButton[@content-desc='Go to previous']");
    private final By monthButton = By.id("month_name");
    private final By buttonMonday = By.xpath("//android.widget.CheckedTextView[1]");
}
