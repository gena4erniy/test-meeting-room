package tests.ui.us32;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.Calendar;
import ui.pages.LocationChoose;
import ui.pages.RoomsPage;

public class TappingSelectedYearButtonInThePopUpScreenWithDatePickerTest extends BaseTest {

    private LocationChoose locationchoose;
    private RoomsPage roomsPage;
    private Calendar calendar;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        roomsPage = new RoomsPage();
        calendar = new Calendar();
        driver.findElement(locationchoose.getNextButton()).click();
        openRoom();
    }

    @Owner("Golcova A.")
    @TmsLink("C5776242")
    @Test(description = "Checking the 'selected year' button in the calendar pop-up window.")
    public void clickingSelectYearButtonTest() {
        String textMonthButton = driver.findElement(roomsPage.getMonthButton()).getText();
        driver.findElement(roomsPage.getMonthButton()).click();
        String textButtonYear = driver.findElement(calendar.getButtonYear()).getText();
        Assert.assertEquals(textButtonYear, textMonthButton.replaceAll("[a-zA-Z ]", ""));
        driver.findElement(calendar.getButtonYear()).click();
        Assert.assertEquals(driver.findElement(calendar.getButtonYear()).getText(), driver.findElement(calendar.getThisYearButton()).getText());
    }
}
