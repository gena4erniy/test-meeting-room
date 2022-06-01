package tests.ui.us21;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class EventTitleContentTests extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5628135")
    @Test(description = "Verification that title contains: 'Event title', 'Event start-end time', 'Event date', 'Event room'.")
    public void EventTitleContentTest() {
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getUpcomingTab()).isSelected(),"The Upcoming control not displays in active mode by default.");
        Assert.assertTrue(driver.findElement(mySpacePage.getEventTitle()).isDisplayed() && driver.findElement(mySpacePage.getEventTime()).isDisplayed() &&
                driver.findElement(mySpacePage.getEventDate()).isDisplayed() && driver.findElement(mySpacePage.getEventRoom()).isDisplayed(),"Event title not contains: 'Event title', 'Event start-end time', 'Event date', 'Event room'.");
    }
}
