package tests.ui.us26;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class SwitchingThemeColourInPullDownMenuTest extends BaseTest {
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
    @TmsLink("5687573")
    @Test(description = "Switching theme colour in pull-down menu")
    public void switchingTheThemeColorTest() {

        driver.findElement(mySpacePage.getSettingsButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getLocationSettings()).isDisplayed()
                        && driver.findElement(mySpacePage.getPopupSwitchDarkTheme()).isDisplayed()
                        && driver.findElement(mySpacePage.getPopupLogOut()).isDisplayed(),
                "The drop-down menu is displayed incorrectly");
        String uncheckedPopupSwitchDarkTheme = driver.findElement(mySpacePage.getPopupSwitchDarkTheme()).getAttribute("checked");
        driver.findElement(mySpacePage.getPopupSwitchDarkTheme()).click();
        driver.findElement(mySpacePage.getSettingsButton()).click();
        String checkedPopupSwitchDarkTheme = driver.findElement(mySpacePage.getPopupSwitchDarkTheme()).getAttribute("checked");
        Assert.assertNotEquals(uncheckedPopupSwitchDarkTheme, checkedPopupSwitchDarkTheme);
        driver.findElement(mySpacePage.getPopupSwitchDarkTheme()).click();
    }
}
