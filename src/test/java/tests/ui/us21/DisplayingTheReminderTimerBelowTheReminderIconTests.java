package tests.ui.us21;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.ModifyEventPage;

public class DisplayingTheReminderTimerBelowTheReminderIconTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        driver.findElement(locationchoose.getSelectButton()).click();
        driver.findElement(countriesPage.getSelectBelarus()).click();
        driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
        driver.findElement(locationchoose.getNextButton()).click();
        setTimeToReminder();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5651206")
    @Test(description = "An active reminder timer displays a time before the event")
    public void displayingTheReminderTimerBelowTheReminderIconTest() {
        Assert.assertTrue(driver.findElement(mySpacePage.getReminderTime()).isDisplayed(), "The reminder has a set time.");
    }
}
