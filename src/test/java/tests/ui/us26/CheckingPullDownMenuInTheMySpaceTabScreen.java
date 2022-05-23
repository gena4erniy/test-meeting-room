package tests.ui.us26;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class CheckingPullDownMenuInTheMySpaceTabScreen extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getNextButton()).click();
    }

    @Owner("Golcova A.")
    @TmsLink("C5687572")
    @Test(description = "Checking drop-down menu in the My Space Tab screen")
    public void mySpaceTabDropDownMenuTest() {
        driver.findElement(mySpacePage.getSettingsButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getLocationSettings()).isDisplayed()
                        && driver.findElement(mySpacePage.getPopupSwitchDarkTheme()).isDisplayed()
                        && driver.findElement(mySpacePage.getPopupLogOut()).isDisplayed(),
                "The drop-down menu is displayed incorrectly");

    }
}
