package tests.ui.us31;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

public class EventCardContentTests extends BaseTest {
    private LocationChoose locationchoose;
    private EventCard eventCard;
    private Calendar calendar;
    CountriesPage countriesPage;
    BelarusCitiesChoose belarusCitiesChoose;



    public EventCardContentTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization2();
        locationchoose = new LocationChoose();
        eventCard = new EventCard();
        calendar = new Calendar();
        countriesPage = new CountriesPage();
        belarusCitiesChoose = new BelarusCitiesChoose();
        if (driver.findElement(locationchoose.getCityTextButton()).getText().equals("Gomel")){
            driver.findElement(locationchoose.getNextButton()).click();
        } else {
            driver.findElement(locationchoose.getSelectButton()).click();
            driver.findElement(countriesPage.getSelectBelarus()).click();
            driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
            driver.findElement(locationchoose.getNextButton()).click();
        }

        openRoom();
    }

    @Owner("Kudayeu S.")
    @TmsLink("5714897")
    @Test(description = "Event card content (User's own event)")
    public void eventContentUser() {
        chooseMonth("September 2022");

        while(!driver.findElement(calendar.getMondayDate()).getText().contains("12")){
            driver.findElement(calendar.getNextButton()).click();
        }

        chooseDay("12");

        driver.findElement(By.xpath("//android.view.View[@index = '0']")).click();

        Assert.assertTrue(driver.findElement(eventCard.getEventTitleModify()).isDisplayed());
        Assert.assertTrue(driver.findElement(eventCard.getEventDeleteModify()).isDisplayed());
        Assert.assertTrue(driver.findElement(eventCard.getEventSave()).isDisplayed());
    }
}
