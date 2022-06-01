package tests.ui.us21;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.BelarusCitiesChoose;
import ui.pages.CountriesPage;
import ui.pages.LocationChoose;
import ui.pages.MySpacePage;

public class DisplayingAReminderIconTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getSelectButton()).click();
        driver.findElement(countriesPage.getSelectBelarus()).click();
        driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
        driver.findElement(locationchoose.getNextButton()).click();
        setTimeToReminder();
    }

    @Owner("Vaskovich K.")
    @TmsLink("5632888")
    @Test(description = "Verification that the reminder exists")
    public void DisplayingAReminderIconTest() {
        Assert.assertTrue(driver.findElement(mySpacePage.getReminderBell()).isDisplayed(), "The reminder not exists");
    }
}
