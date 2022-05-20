package tests.ui.us24;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.ModifyEventPage;

import java.net.MalformedURLException;

public class TappingReminderButtonTests extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        driver.findElement(locationchoose.getNextButton()).click();

    }

    @Owner("Sirozh E.")
    @TmsLink("5686804")
    @Test(description = "Tap 'Reminder' button in the Modify Event screen , Pay attention to the Reminder")
    public void tappingReminderbutton() {
        driver.findElement(mySpacePage.getEventTitle()).click();
        Assert.assertTrue(driver.findElement(modifyEventPage.getPageTitle()).isDisplayed());
        Assert.assertTrue(driver.findElement(mySpacePage.getRoomsTitle()).isEnabled(), " Блокирует работу приложения до тех пор, пока Пользователь не сохранит изменения или не отменит операцию.\n" +
                "        //не блокирует");
        Assert.assertEquals(driver.findElement(modifyEventPage.getButtonReminder()).getText(), "Never");
        Assert.assertTrue(driver.findElement(modifyEventPage.getTimePickerStart()).isDisplayed());
        Assert.assertTrue(driver.findElement(modifyEventPage.getTimePickerEnd()).isDisplayed());

    }
//    @AfterClass
//    public void closeDriver() {
//        driver.quit();
//    }
}

