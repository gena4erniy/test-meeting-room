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



    public EventCardContentTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization2();
        locationchoose = new LocationChoose();
        eventCard = new EventCard();
        calendar = new Calendar();
        driver.findElement(locationchoose.getNextButton()).click();
        openRoom();
    }

    @Owner("Kudayeu S.")
    @TmsLink("5714897")
    @Test(description = "Event card content (User's own event)")
    public void eventContentUser() {
        chooseMonth("July 2022");

        while(!driver.findElement(calendar.getMondayDate()).getText().contains("11")){
            driver.findElement(calendar.getNextButton()).click();
        }

        chooseDay("15");

        driver.findElement(By.xpath("//android.view.View[@index = '0']")).click();

        Assert.assertTrue(driver.findElement(eventCard.getEventDate()).isDisplayed() &&
                driver.findElement(eventCard.getRoomName()).isDisplayed() &&
                driver.findElement(eventCard.getEventime()).isDisplayed() &&
                driver.findElement(eventCard.getEventTitle()).isDisplayed() &&
               driver.findElement(eventCard.getEventdescription()).isDisplayed() &&
               driver.findElement(eventCard.getNameOfOwner()).isDisplayed() &&
               driver.findElement(eventCard.getPositionOfOwner()).isDisplayed() &&
               driver.findElement(eventCard.getEmailOfOwner()).isDisplayed() &&
              driver.findElement(eventCard.getLine()).isDisplayed() &&
               driver.findElement(eventCard.getButtonProfile()).isDisplayed() &&
              driver.findElement(eventCard.getButtonMail()).isDisplayed() &&
              driver.findElement(eventCard.getButtonSkype()).isDisplayed() &&
               driver.findElement(eventCard.getSkypeOfOwner()).isDisplayed() , "Card is not coincide");
    }
}
