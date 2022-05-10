package ui.pages;

import org.openqa.selenium.By;

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
    private final By reminderTime=By.id("event_reminder_counter_upcoming");

    public By getMySpaceTitle() {
        return mySpaceTitle;
    }

    public By getEventCard() {
        return eventCard;
    }

    public By getEventTitle() {
        return eventTitle;
    }

    public By getEventTime() {
        return eventTime;
    }

    public By getEventDate() {
        return eventDate;
    }

    public By getEventRoom() {
        return eventRoom;
    }

    public By getReminderBell() {
        return reminderBell;
    }

    public By getReminderTime() {
        return reminderTime;
    }

    public By getSettingsButton() {
        return settingsButton;
    }

    public By getLocationSettings() {
        return locationSettings;
    }

    public By getUpcomingTab() {
        return upcomingTab;
    }

    public By getHistoryTab() {
        return historyTab;
    }
}
