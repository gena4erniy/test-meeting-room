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

public class TapingMounthYYYYbuttonTest extends BaseTest {

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
    @TmsLink("5776238")
    @Test(description = "Checking the tap of the 'Month YYYY' button")
    public void clickingSelectDateButtonTest() {
        driver.findElement(roomsPage.getMonthButton()).click();
        Assert.assertTrue(driver.findElement(calendar.getButtonOk()).isDisplayed()
                        && driver.findElement(calendar.getButtonCancel()).isDisplayed()
                        && driver.findElement(calendar.getButtonNextInCalendar()).isDisplayed(),
                "The calendar page is displayed incorrectly.");
    }
}
