package tests.ui.us24;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.ModifyEventPage;
import ui.pages.modifyEvent.ModifyReminderPage;

import java.net.MalformedURLException;
import java.util.List;

public class CheckingReminderTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;
    private ModifyReminderPage modifyReminderPage;

    @BeforeClass
    private void preconditions() throws MalformedURLException {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        modifyReminderPage = new ModifyReminderPage();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getEventTitle()).click();

    }

    @Owner("Sirozh E.")
    @TmsLink("5686808")
    @Test(description = "The List containts next values:")
    public void ListOfReminders() {
        Assert.assertTrue(driver.findElement(modifyEventPage.getPageTitle()).isDisplayed());
        Assert.assertTrue(driver.findElement(mySpacePage.getRoomsTitle()).isEnabled(), " Блокирует работу приложения до тех пор, пока Пользователь не сохранит изменения или не отменит операцию.\n" +
                "        //не блокирует");
//        Assert.assertEquals(driver.findElement(modifyEventPage.getTextReminder()).getText(), "Never");
        driver.findElement(modifyEventPage.getButtonReminder()).click();
        Assert.assertTrue(driver.findElement(modifyReminderPage.getListReminder()).isDisplayed());
        List<AndroidElement> chekListReminder = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView"));

//        Assert.assertTrue(driver.findElement(modifyEventPage.getTimePickerEnd()).isDisplayed());
//        if (chekListReminder.size() == 8) ;
//        else System.out.println("FAIL");
Assert.assertEquals(chekListReminder.size(),"8");

    }
//    @AfterClass
//    public void closeDriver() {
//        driver.quit();
//    }
}

