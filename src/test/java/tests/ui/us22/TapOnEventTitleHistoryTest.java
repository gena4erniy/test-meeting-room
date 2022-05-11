package tests.ui.us22;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class TapOnEventTitleHistoryTest extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getHistoryTab()).click();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5628136")
    @Test(description = "Verify that event card contains: 'Event title', 'Event start-end time', 'Event date', 'Event room', 'Event owner name', 'Event owner position', 'Event owner Skype ID', 'Event owner e-mail', 'Event description'.   ")
    public void TapOnEventTitleHistoryTest() {
        driver.findElement(mySpacePage.getEventCard()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getEventCard()).isDisplayed() && driver.findElement(mySpacePage.getEventTitle()).isDisplayed() &&
                driver.findElement(mySpacePage.getEventTime()).isDisplayed() && driver.findElement(mySpacePage.getEventDate()).isDisplayed() &&
                driver.findElement(mySpacePage.getEventRoom()).isDisplayed() && driver.findElement(mySpacePage.getNameOfBooker()).isDisplayed() &&
                driver.findElement(mySpacePage.getRoleOFBooker()).isDisplayed() && driver.findElement(mySpacePage.getBookerSkype()).isDisplayed() &&
                driver.findElement(mySpacePage.getBookerEmail()).isDisplayed(), "Event card not contains: 'Event title', 'Event start-end time', 'Event date', 'Event room', 'Event owner name', 'Event owner position', 'Event owner Skype ID', 'Event owner e-mail', 'Event description'.    ");
    }

}
