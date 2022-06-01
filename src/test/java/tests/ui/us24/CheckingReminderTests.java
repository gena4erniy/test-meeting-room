package tests.ui.us24;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.ModifyEventPage;
import ui.pages.modifyEvent.ModifyReminderPage;
import java.util.List;

public class CheckingReminderTests extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;
    private ModifyReminderPage modifyReminderPage;

    @BeforeClass
    private void preconditions() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        modifyReminderPage = new ModifyReminderPage();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getEventTitle()).click();
    }

    @Ignore
    @Owner("Sirozh E.")
    @TmsLink("5686808")
    @Test(description = "The List containts next values:")
    public void checkListOfReminders() {
        Assert.assertTrue(driver.findElement(modifyEventPage.getPageTitle()).isDisplayed());
        Assert.assertTrue(driver.findElement(mySpacePage.getRoomsTitle()).isEnabled(), " Блокирует работу приложения до тех пор, пока Пользователь не сохранит изменения или не отменит операцию.\n" +
                "        //не блокирует");
        driver.findElement(modifyEventPage.getButtonReminder()).click();
        Assert.assertTrue(driver.findElement(modifyReminderPage.getListReminder()).isDisplayed());
        List<AndroidElement> chekListReminder = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView"));
        Assert.assertEquals(chekListReminder.size(), "8");
    }
}

