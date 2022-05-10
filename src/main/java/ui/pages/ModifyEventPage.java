package ui.pages;

import org.openqa.selenium.By;

public class ModifyEventPage {
    private final By reminder = By.id("set_reminder");
    private final By reminder5Min= By.xpath("//android.view.ViewGroup[3]/android.widget.RadioButton");
    private final By save = By.id("button_save_toolbar");
    private final By pageTitle = By.xpath("//android.widget.TextView[@text = 'Modify event']");

    public By getReminder() {
        return reminder;
    }

    public By getReminder5Min() {
        return reminder5Min;
    }

    public By getSave() {
        return save;
    }

    public By getPageTitle() {
        return pageTitle;
    }
}
