package tests.ui.us25;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.CustomReminderPage;
import ui.pages.modifyEvent.DeleteEventPage;
import ui.pages.modifyEvent.ModifyEventPage;
import ui.pages.modifyEvent.ModifyReminderPage;

import java.net.MalformedURLException;

public class ChekingDeleteEventTest extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;
    private ModifyReminderPage modifyReminderPage;
    private CustomReminderPage customReminderPage;
    private DeleteEventPage deleteEventPage;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        modifyReminderPage = new ModifyReminderPage();
        customReminderPage = new CustomReminderPage();
        deleteEventPage = new DeleteEventPage();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getEventTitle()).click();

    }

    @Owner("Sirozh E.")
    @TmsLink("5687563")
    @Test(description = "'Delete the event' Pop-over dialogue appears , 'Delete the event' Pop-over dialogue mathes the mockup.")
    public void checkDeleteEvent() {
        driver.findElement(modifyEventPage.getDeleteEventButton()).click();
        Assert.assertTrue(driver.findElement(deleteEventPage.getDeleteEventTitle()).isDisplayed());

//        Assert.assertTrue(driver.findElement(modifyEventPage.getPageTitle()).isDisplayed());
//        driver.findElement(modifyEventPage.getReminder()).click();
//        Assert.assertTrue(driver.findElement(modifyReminderPage.getCustomButton()).isEnabled());
//        driver.findElement(modifyReminderPage.getCustomButton()).click();
//        Assert.assertTrue(driver.findElement(customReminderPage.getPopUpWindow()).isDisplayed());
//        driver.findElement(customReminderPage.getInputTime()).click();
//        //При нажатии отображается цифровая клавиатура "Цифры, кнопка обратного пробела".
//        //не инспектируется
    }
}