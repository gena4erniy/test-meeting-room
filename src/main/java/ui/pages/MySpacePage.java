package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class MySpacePage {
    private final By mySpaceTitle = By.xpath("//android.widget.TextView[@text = 'My space']");
    private final By settingsButton = By.id("mrtoolbar_icon");
    private final By locationSettings = By.id("popup_local_settings");
    private final By upcomingTab = By.xpath("//android.widget.LinearLayout[@content-desc='Upcoming']");
    private final By historyTab = By.xpath("//android.widget.LinearLayout[@content-desc='History']");
    private final By eventCard = By.id("event_card_upcoming_root");
    private final By eventTitle = By.id("event_title_upcoming");
    private final By eventTime = By.id("event_planned_time_upcoming");
    private final By eventDate = By.id("event_planned_date_upcoming");
    private final By eventRoom = By.id("event_room_upcoming");
    private final By reminderBell = By.id("event_reminder_bell_upcoming");
    private final By reminderTime = By.id("event_reminder_counter_upcoming");
    private final By noEventMessage = By.xpath("//android.widget.TextView[@text = 'No events booked in the last 10 days']");
    private final By nameOfBooker = By.id("name_of_booker");
    private final By roleOFBooker = By.id("role_of_booker");
    private final By bookerEmail = By.id("booker_email");
    private final By bookerSkype = By.id("booker_skype");
}
