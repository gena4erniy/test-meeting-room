package tests.ui.us21;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

public class SwitchingBetweenSegmentedControlsTests extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5628130")
    @Test(description = "Verification that the History control is shown active. The Upcoming control displaying in inactive mode.")
    public void SwitchingBetweenSegmentedControlsTest() {
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getUpcomingTab()).isSelected(),"The Upcoming control not displays in active mode by default.");
        driver.findElement(mySpacePage.getHistoryTab()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getHistoryTab()).isSelected(),"The History control not displays in active mode by default.");
    }
}
