package ui.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;

public class MySpaceScreen extends BaseScreen {

    @FindBy(id = "mrtoolbar_title")
    private WebElement title;

    @FindBy(id = "mrtoolbar_icon")
    private WebElement settingsButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Upcoming']")
    private WebElement upcomingTab;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='History']")
    private WebElement historyTab;

    @FindBy(id = "upcoming_events_recycler_view")
    private WebElement allEventCards;

    private By eventColorLine = By.id("event_city_colour_line_upcoming");
    private By eventTitle = By.id("event_title_upcoming");
    private By eventPlannedTime = By.id("event_planned_time_upcoming");
    private By eventPlannedDate = By.id("event_planned_date_upcoming");
    private By eventReminderBell = By.id("event_reminder_bell_upcoming");
    private By eventRoom = By.id("event_room_upcoming");

    public String getTitle() {
        return title.getText();
    }

    public void tapSettingsButton() {
        settingsButton.click();
    }

    public void tapUpcomingTab() {
        upcomingTab.click();
    }

    public boolean getUpcomingTabVisibility() {
        return upcomingTab.isEnabled();
    }

    public boolean getUpcomingTabActivity() {
        return upcomingTab.isSelected();
    }

    public void tapHistoryTab() {
        historyTab.click();
    }

    public boolean getHistoryTabVisibility() {
        return historyTab.isEnabled();
    }

    public boolean getHistoryTabActivity() {
        return historyTab.isSelected();
    }

    public boolean getAllEventCardsVisibility() {
        return allEventCards.isEnabled();
    }

    public List<WebElement> getAllEventCards() {
        return allEventCards.findElements(By.id("event_card_upcoming_root"));
    }

    public int getAllEventCardsSize() {
        return getAllEventCards().size();
    }

    public boolean checkAllEventCardsIsEmpty() {
        return getAllEventCards().isEmpty();
    }

    public String getEventTitle(int index) {
        return getAllEventCards().get(index).findElement(eventTitle).getText();
    }

    public boolean getEventTitleVisibility(int index) {
        return getAllEventCards().get(index).findElement(eventTitle).isEnabled();
    }

    public boolean getEventPlannedTimeVisibility(int index) {
        return getAllEventCards().get(index).findElement(eventPlannedTime).isEnabled();
    }

    public String getEventPlannedDate(int index) {
        return getAllEventCards().get(index).findElement(eventPlannedDate).getText();
    }

    public boolean getEventPlannedDateVisibility(int index) {
        return getAllEventCards().get(index).findElement(eventPlannedDate).isEnabled();
    }

    public String getEventRoom(int index) {
        return getAllEventCards().get(index).findElement(eventRoom).getText();
    }

    public boolean getEventRoomVisibility(int index) {
        return getAllEventCards().get(index).findElement(eventRoom).isEnabled();
    }

    public void tapEventCard(int index) {
        getAllEventCards().get(index).click();
    }

    public void horizontalSwipe(AppiumDriver<WebElement> driver, int y, int startX, int endX) {
        TouchAction action = new TouchAction(driver);
        action.press(point(startX, y)).waitAction().moveTo(point(endX, y)).release().perform();
    }

    public void horizontalSwipe(String direction, AppiumDriver<WebElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int y = size.getHeight() / 2;
        int startX;
        int endX;
        switch (direction) {
            case "left":
                startX = (int) (size.getWidth() * 0.8);
                endX = (int) (size.getWidth() * 0.2);
                horizontalSwipe(driver, y, startX, endX);
                break;
            case "right":
                startX = (int) (size.getWidth() * 0.2);
                endX = (int) (size.getWidth() * 0.8);
                horizontalSwipe(driver, y, startX, endX);
                break;
            default:
                System.out.println("Unknown direction");
        }
    }
}
