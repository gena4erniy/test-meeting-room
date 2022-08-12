package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModifyEventScreen extends BaseScreen {

    @FindBy(id = "toolbar_save_cancel")
    private WebElement toolbarSaveCancelButton;

    @FindBy(id = "toolbar_save_title")
    private WebElement toolbarSaveTitle;

    @FindBy(id = "button_save_toolbar")
    private WebElement toolbarSaveButton;

    @FindBy(id = "event_modify_title")
    private WebElement eventModifyTitle;

    @FindBy(id = "modify_divider_line_1")
    private WebElement lineUnderEventModifyTitle;

    @FindBy(id = "modify_time_icon")
    private WebElement modifyTimeIcon;

    @FindBy(id = "modify_start_date_picker")
    private WebElement modifyStartDatePicker;

    @FindBy(id = "modify_start_time_picker")
    private WebElement modifyStartTimePicker;

    @FindBy(id = "modify_event_end_date")
    private WebElement modifyEndDatePicker;

    @FindBy(id = "modify_end_time_picker")
    private WebElement modifyEndTimePicker;

    @FindBy(id = "modify_divider_line_2")
    private WebElement lineUnderDateTimePicker;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.andersenlab.meeting_room.debug:id/modify_room_chooser']/*[@index=0]")
    private WebElement doorIcon;

    @FindBy(id = "event_room_name")
    private WebElement roomColorText;

    @FindBy(id = "modify_divider_line_3")
    private WebElement lineUnderDoorIcon;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.andersenlab.meeting_room.debug:id/set_reminder']/*[@index=0]")
    private WebElement reminderIcon;

    @FindBy(id = "reminder_left_time")
    private WebElement reminderLeftTime;

    @FindBy(id = "description_of_event_icon")
    private WebElement descriptionEventIcon;

    @FindBy(id = "user_event_description")
    private WebElement eventDescriptionField;

    @FindBy(id = "modify_divider_line_4")
    private WebElement lineUnderDescription;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.andersenlab.meeting_room.debug:id/modify_delete_event']/*[@index=0]")
    private WebElement deleteIcon;

    @FindBy(id = "tv_delete_event")
    private WebElement deleteEventButton;

    public String getTitle() {
        return toolbarSaveTitle.getText();
    }

    public void tapToolbarSaveCancelButton() {
        toolbarSaveCancelButton.click();
    }

    public boolean getToolbarSaveCancelButtonVisibility() {
        return toolbarSaveCancelButton.isDisplayed();
    }

    public void enterEventModifyTitle (String eventTitle) {
        eventModifyTitle.sendKeys(eventTitle);
    }

    public String getEventModifyTitle () {
        return eventModifyTitle.getText();
    }

    public int getEventModifyTitleLength () {
        return eventModifyTitle.getText().length();
    }

    public void enterEventDescription(String eventDescription) {
        eventDescriptionField.sendKeys(eventDescription);
    }

    public String getEventDescription () {
        return eventDescriptionField.getText();
    }

    public int getEventDescriptionLength () {
        return eventDescriptionField.getText().length();
    }

    public boolean getModifyTimeIconVisibility() {
        return modifyTimeIcon.isDisplayed();
    }

    public boolean getDoorIconVisibility() {
        return doorIcon.isDisplayed();
    }

    public boolean getLineUnderEventModifyTitleVisibility() {
        return lineUnderEventModifyTitle.isDisplayed();
    }
}
