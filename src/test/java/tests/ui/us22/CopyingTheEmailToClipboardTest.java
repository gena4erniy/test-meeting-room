package tests.ui.us22;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.constants.Constant;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class CopyingTheEmailToClipboardTest extends BaseTest {

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

    @Owner("Golcova A.")
    @TmsLink("5628139")
    @Test(description = "Copying the e-mail field's contents to the device clipboard")
    public void TapOnEventTitleHistoryTest() {
        driver.findElement(mySpacePage.getEventTitle()).click();
        Assert.assertEquals(driver.findElement(mySpacePage.getNotificationOfBookedEvents()).getText(), "Events booked in the last 10 days");
        driver.findElements(mySpacePage.getEventCard()).get(1).click();
        Assert.assertEquals(driver.findElement(mySpacePage.getBookerEmail()).getText(), Constant.ValidCredo.VALID_MAIL);
        Assert.assertTrue(driver.findElement(mySpacePage.getMailIconImage()).isDisplayed(),"The image of the mail icon is missing");
        driver.findElements(mySpacePage.getBookerEmail()).get(1).click();
        driver.findElement(mySpacePage.getButtonCopy()).click();

    }
}
