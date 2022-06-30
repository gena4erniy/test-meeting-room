package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class EventCard {
    private final By roomName = By.xpath("//android.widget.TextView[@text = 'Red']");
    private final By eventDate = By.xpath("//android.widget.TextView[@text = 'Mon, 12 Sep']");
    private final By eventime = By.xpath("//android.widget.TextView[@text = '06:30-08:30']");
    private final By eventTitle = By.xpath("//android.widget.TextView[@text = 'New title']");
    private final By eventdescription = By.xpath("//android.widget.TextView[@text = 'New comment']");
    private final By nameOfOwner = By.xpath("//android.widget.TextView[@text = 'Andrei Dashkevich']");
    private final By positionOfOwner = By.xpath("//android.widget.TextView[@text = 'PM']");
    private final By emailOfOwner = By.xpath("//android.widget.TextView[@text = 'user1@gmail.com']");
    private final By line = By.xpath("//android.view.View[@index = '5']");
    private final By buttonProfile = By.xpath("//android.widget.ImageView[@index = '7']");
    private final By buttonMail = By.xpath("//android.widget.ImageView[@index = '10']");
    private final By buttonSkype = By.xpath("//android.widget.ImageView[@index = '12']");
    private final By skypeOfOwner = By.xpath("//android.widget.TextView[@text = 'live:.cid.11111']");
    private final By eventTitleModify = By.id("event_modify_title");
    private final By eventDeleteModify = By.id("modify_delete_event");
    private final By eventSave = By.id("button_save_toolbar");
}
