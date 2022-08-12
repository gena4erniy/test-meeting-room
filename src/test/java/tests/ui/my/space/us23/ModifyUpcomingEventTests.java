package tests.ui.my.space.us23;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.AuthorizationStep;
import steps.LocationStep;
import steps.ModifyEventStep;
import steps.MySpaceStep;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

@Epic("My Space")
@Feature("US 2.3")
public class ModifyUpcomingEventTests extends BaseUiTest {

    private AuthorizationStep authorizationStep = new AuthorizationStep();
    private LocationStep locationStep = new LocationStep();
    private MySpaceStep mySpaceStep = new MySpaceStep();
    private ModifyEventStep modifyEventStep = new ModifyEventStep();

    @BeforeMethod
    public void beforeMethod() {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail(VALID_MAIL);
        authorizationStep.enterPassword(VALID_PASS);
        authorizationStep.tapOnLogInButton();
        locationStep.onLocationScreen();
        locationStep.tapNextButton();
        mySpaceStep.onMySpaceScreen();
    }

    @Owner("Danilenko D.")
    @TmsLink("5678931")
    @Test(description = "Displaying Modify event screen")
    public void displayingModifyEventScreen() {
        mySpaceStep.checkAllEventCardsVisibility(true, "A list of upcoming events is not displayed.");
        mySpaceStep.tapEventCard(0);
        modifyEventStep.onMySpaceScreen();
        modifyEventStep.verifyTitle("Modify event", "Title does not match");
        modifyEventStep.checkModifyTimeIconVisibility(true, "Modify time icon not visible");
        modifyEventStep.checkDoorIconVisibility(true, "Door icon not visible");
        modifyEventStep.checkLineUnderEventModifyTitleVisibility(true, "Line under event modify title not visible");
        authorizationStep.checkAll();
    }

    @Owner("Danilenko D.")
    @TmsLink("5679058")
    @Test(description = "Tapping 'X icon' Button in the Modify event screen")
    public void tappingToolbarSaveCancelButtonInModifyEventScreen() {
        mySpaceStep.checkAllEventCardsVisibility(true, "A list of upcoming events is not displayed.");
        mySpaceStep.tapEventCard(0);
        modifyEventStep.onMySpaceScreen();
        modifyEventStep.verifyTitle("Modify event", "Title does not match");
        modifyEventStep.checkToolbarSaveCancelButtonVisibility(true, "Toolbar save cancel button not visible");
        modifyEventStep.tapToolbarSaveCancelButton();
        mySpaceStep.checkUpcomingTabVisibility(true, "Upcoming tab is not displaying");
        mySpaceStep.checkUpcomingTabActivity(true, "Upcoming tab is not shown active");
        authorizationStep.checkAll();
    }

    @DataProvider(name = "Create data for 5679068 test")
    public Object[][] createDataForEventTitleTextField() {
        return new Object[][]{
                {"", "Event title", 11},
                {"q", "q", 1},
                {"qdawdzdcbrxcvxbngcfxvfgcb", "qdawdzdcbrxcvxbngcfxvfgcb", 25},
                {"qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcb", "qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcb", 50},
                {"qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbs", "qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcb", 50},
        };
    }

    @Owner("Danilenko D.")
    @TmsLink("5679068")
    @Test(dataProvider = "Create data for 5679068 test", description = "Inputting an event title in 'Event title' Text field in the Modify event screen")
    public void inputtingAnEventTitleInEventTitleTextFieldInTheModifyEventScreen(String eventTitle, String expectedEventTitle, int expectedLength) {
        mySpaceStep.checkAllEventCardsVisibility(true, "A list of upcoming events is not displayed.");
        mySpaceStep.tapEventCard(0);
        modifyEventStep.onMySpaceScreen();
        modifyEventStep.verifyTitle("Modify event", "Title does not match");
        modifyEventStep.enterEventModifyTitle(eventTitle);
        modifyEventStep.verifyEventModifyTitle(expectedEventTitle, "Event title not equal expected event title");
        modifyEventStep.verifyEventModifyTitleLength(expectedLength, "Event title length not equal expected length");
        authorizationStep.checkAll();
    }

    @DataProvider(name = "Create data for 5679079 test")
    public Object[][] createDataForEventDescriptionTextField() {
        return new Object[][]{
                {"", "Event description", 17},
                {"q", "q", 1},
                {"qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawd", "qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawd", 80},
                {"qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcb", "qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcb", 150},
                {"qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbq", "qdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcbqdawdzdcbrxcvxbngcfxvfgcb", 150},
        };
    }

    @Owner("Danilenko D.")
    @TmsLink("5679079")
    @Test(dataProvider = "Create data for 5679079 test", description = "Inputting an event description in 'Event description' Text field in the Modify event screen")
    public void inputtingAnEventDescriptionInEventDescriptionTextFieldInTheModifyEventScreen(String eventDescription, String expectedEventDescription, int expectedLength) {
        mySpaceStep.checkAllEventCardsVisibility(true, "A list of upcoming events is not displayed.");
        mySpaceStep.tapEventCard(0);
        modifyEventStep.onMySpaceScreen();
        modifyEventStep.verifyTitle("Modify event", "Title does not match");
        modifyEventStep.enterEventDescription(eventDescription);
        modifyEventStep.verifyEventDescription(expectedEventDescription, "Event title not equal expected event title");
        modifyEventStep.verifyEventDescriptionLength(expectedLength, "Event title length not equal expected length");
        authorizationStep.checkAll();
    }
}
