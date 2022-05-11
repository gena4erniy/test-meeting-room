package tests.ui.us21;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class DisplayingUpcomingScreenWhenThereAreNoEventsTest extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorizationWithNoEvents();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5628133")
    @Test(description = "Verify that no events booked in the last 10 days.")
    public void DisplayingUpcomingScreenWhenThereAreNoEventsTest() {
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getNoEventsMessageUpcomingTab()).isDisplayed(),"No events booked");
    }
}
