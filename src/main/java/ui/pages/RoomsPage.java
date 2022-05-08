package ui.pages;

import org.openqa.selenium.By;

public class RoomsPage {
   // private final By roomsTitle = By.xpath("//android.widget.FrameLayout[@content-desc='Rooms']/android.widget.ImageView");
    private final By nextDate = By.id("com.andersenlab.meeting_room.debug:id/next");
    private final By choseDate = By.xpath("//android.widget.CheckedTextView[@content-desc='9']");
    private final By choseEvent = By.id("com.andersenlab.meeting_room.debug:id/eventView");

 private final By eventCard = By.id("com.andersenlab.meeting_room.debug:id/event_card_upcoming_root");

    public By getEventCard() {
        return eventCard;
    }

    public By getNextDate() {
        return nextDate;
    }

    public By getChoseDate() {
        return choseDate;
    }
    public By getChoseEvent(){
        return choseEvent;
    }
}
