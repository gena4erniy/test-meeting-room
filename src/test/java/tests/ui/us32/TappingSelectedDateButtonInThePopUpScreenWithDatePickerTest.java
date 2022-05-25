package tests.ui.us32;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.Calendar;
import ui.pages.LocationChoose;
import ui.pages.RoomsPage;

public class TappingSelectedDateButtonInThePopUpScreenWithDatePickerTest extends BaseTest {
    private LocationChoose locationchoose;
    private RoomsPage roomsPage;
    private Calendar calendar;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        roomsPage = new RoomsPage();
        calendar = new Calendar();
        driver.findElement(locationchoose.getNextButton()).click();
        openRoom();
    }

    @Owner("Golcova A.")
    @TmsLink("C5776243")
    @Test(description = "Checking the 'Www, dd Mmm' button with the selected date in the calendar pop-up window.")
    public void clickingSelectDateButtonTest() {

        driver.findElement(roomsPage.getMonthButton()).click();
        driver.findElement(calendar.getButtonYear()).click();
        Assert.assertTrue(driver.findElement(calendar.getThisYearButton()).isDisplayed());
        driver.findElement(calendar.getDateSelectionButton()).click();
        Assert.assertTrue(driver.findElement(calendar.getButtonNextInCalendar()).isDisplayed());
        driver.findElement(calendar.getDateSelectionButton()).click();
        Assert.assertTrue(driver.findElement(calendar.getButtonNextInCalendar()).isDisplayed());
    }
}
