package tests.ui.us21;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.ModifyEventPage;

public class TapOnEventTitleUpcomingTests extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();

        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getUpcomingTab()).isSelected(), "The Upcoming control not displays in active mode by default.");
    }

    @Owner("Vaskovich K.")
    @TmsLink("5634863")
    @Test(description = "Verification that the Modify Event screen is displayed")
    public void TapOnEventTitleUpcomingTest() {
        Assert.assertTrue(driver.findElement(mySpacePage.getEventTitle()).isDisplayed() && driver.findElement(mySpacePage.getEventTime()).isDisplayed() &&
                driver.findElement(mySpacePage.getEventDate()).isDisplayed() && driver.findElement(mySpacePage.getEventRoom()).isDisplayed(), "Event title not contains: 'Event title', 'Event start-end time', 'Event date', 'Event room'.");
        driver.findElement(mySpacePage.getEventCard()).click();
        Assert.assertTrue(driver.findElement(modifyEventPage.getPageTitle()).isDisplayed(),"Modify Event screen for that booking is not displayed");
    }
}
