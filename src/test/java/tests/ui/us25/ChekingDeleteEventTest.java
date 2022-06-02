package tests.ui.us25;

import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import ui.pages.modifyEvent.DeleteEventPage;
import ui.pages.modifyEvent.ModifyEventPage;

public class ChekingDeleteEventTest extends BaseTest {
    private LocationChoose locationchoose;
    private MySpacePage mySpacePage;
    private ModifyEventPage modifyEventPage;
    private DeleteEventPage deleteEventPage;

    @BeforeClass
    private void preconditions() {
        authorization();
        locationchoose = new LocationChoose();
        mySpacePage = new MySpacePage();
        modifyEventPage = new ModifyEventPage();
        deleteEventPage = new DeleteEventPage();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getEventTitle()).click();
    }

    @Owner("Sirozh E.")
    @TmsLink("5687563")
    @Test(description = "'Delete the event' Pop-over dialogue appears , 'Delete the event' Pop-over dialogue mathes the mockup.")
    public void checkDeleteEvent(){
        driver.findElement(modifyEventPage.getDeleteEventButton()).click();
        Assert.assertTrue(driver.findElement(deleteEventPage.getDeleteEventTitle()).isDisplayed());
    }
}