package tests.ui.us22;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class DisplayingMyScreenHistoryWhenThereAreNoPastEventsTest extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorizationWithNoEvents();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5628140")
    @Test(description = "Verify that no events booked in the last 10 days.")
    public void DisplayingMyScreenHistoryWhenThereAreNoPastEventsTest() {
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getUpcomingTab()).isSelected(),"The Upcoming control not displays in active mode by default.");
        driver.findElement(mySpacePage.getHistoryTab()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getNoEventMessageHistoryTab()).isDisplayed(),"No events booked in the last 10 days is not displayed on Tiles List Placeholder.");
    }
}
