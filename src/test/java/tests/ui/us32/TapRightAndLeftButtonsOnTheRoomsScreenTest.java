package tests.ui.us32;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.LocationChoose;
import ui.pages.RoomsPage;

public class TapRightAndLeftButtonsOnTheRoomsScreenTest extends BaseTest {

    private LocationChoose locationchoose;
    private RoomsPage roomsPage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        roomsPage = new RoomsPage();
        driver.findElement(locationchoose.getNextButton()).click();
        openRoom();
    }

    @Owner("Golcova A.")
    @TmsLink("C5774003")
    @Test(description = "Checking the tap of the '<' and '>' button in Rooms screen")
    public void clickingTheScrollButtonsTest() {

        String textButtonMonday = driver.findElement(roomsPage.getButtonMonday()).getText();
        driver.findElement(roomsPage.getPreviousButton()).click();
        String textButtonMonday2 = driver.findElement(roomsPage.getButtonMonday()).getText();
        Assert.assertNotEquals(textButtonMonday, textButtonMonday2);
        driver.findElement(roomsPage.getNextDate()).click();
    }
}
