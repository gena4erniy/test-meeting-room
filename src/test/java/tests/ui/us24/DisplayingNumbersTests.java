package tests.ui.us24;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.CustomReminderPage;
import ui.pages.modifyEvent.ModifyEventPage;
import ui.pages.modifyEvent.ModifyReminderPage;

import java.net.MalformedURLException;

public class DisplayingNumbersTests extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;
    private ModifyReminderPage modifyReminderPage;
    private CustomReminderPage customReminderPage;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        modifyReminderPage = new ModifyReminderPage();
        customReminderPage = new CustomReminderPage();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getEventTitle()).click();

    }

    @Owner("Sirozh E.")
    @TmsLink("5687107")
    @Test(description = "Displaying 'Numbers, backspace button' Numeric keyboard (Set Reminder dialogue screen)")
    public void checkDisplayingNumbers() {
        Assert.assertTrue(driver.findElement(modifyEventPage.getPageTitle()).isDisplayed());
        driver.findElement(modifyEventPage.getReminder()).click();
        Assert.assertTrue(driver.findElement(modifyReminderPage.getCustomButton()).isEnabled());
        driver.findElement(modifyReminderPage.getCustomButton()).click();
        Assert.assertTrue(driver.findElement(customReminderPage.getPopUpWindow()).isDisplayed());
        driver.findElement(customReminderPage.getInputTime()).click();
        //При нажатии отображается цифровая клавиатура "Цифры, кнопка обратного пробела".
        //не инспектируется



    }
}
