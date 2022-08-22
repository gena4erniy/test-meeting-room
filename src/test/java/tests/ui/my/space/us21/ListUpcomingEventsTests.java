package tests.ui.my.space.us21;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.AuthorizationStep;
import steps.LocationStep;
import steps.ModifyEventStep;
import steps.MySpaceStep;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

@Epic("My Space")
@Feature("US 2.1")
public class ListUpcomingEventsTests extends BaseUiTest {

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
    @TmsLink("5628130")
    @Test(description = "Switching between segmented controls")
    public void switchingBetweenSegmentedControls() {
        mySpaceStep.checkUpcomingTabVisibility(true, "Upcoming tab is not displaying");
        mySpaceStep.checkUpcomingTabActivity(true, "Upcoming tab is not shown active");
        mySpaceStep.tapHistoryTab();
        mySpaceStep.checkHistoryTabVisibility(true, "History tab is not displaying");
        mySpaceStep.checkHistoryTabActivity(true, "History tab is not shown active");
        mySpaceStep.checkUpcomingTabVisibility(true, "Upcoming tab is not displaying");
        mySpaceStep.checkUpcomingTabActivity(false, "Upcoming tab is shown active");
        authorizationStep.checkAll();
    }

    @Owner("Danilenko D.")
    @TmsLink("5634863")
    @Test(description = "Tap on Event tile (Upcoming)")
    public void tapOnEventTileUpcoming() {
        mySpaceStep.checkAllEventCardsVisibility(true, "A list of upcoming events is not displayed.");
        mySpaceStep.checkEventTitleVisibility(0, true, "Event title not visible");
        mySpaceStep.checkEventPlannedTimeVisibility(0, true, "Event planned time not visible");
        mySpaceStep.checkEventPlannedDateVisibility(0, true, "Event planned date not visible");
        mySpaceStep.checkEventRoomVisibility(0, true, "Event room not visible");
        mySpaceStep.tapEventCard(0);
        modifyEventStep.onMySpaceScreen();
        modifyEventStep.verifyTitle("Modify event", "Title does not match");
        authorizationStep.checkAll();
    }

    @Owner("Danilenko D.")
    @TmsLink("5634856")
    @Test(description = "Swipe tabs")
    public void swipeTabs() {
        mySpaceStep.checkUpcomingTabVisibility(true, "Upcoming tab is not displaying");
        mySpaceStep.checkUpcomingTabActivity(true, "Upcoming tab is not shown active");
        mySpaceStep.horizontalSwipe("left", driver);
        mySpaceStep.checkHistoryTabVisibility(true, "History tab is not displaying");
        mySpaceStep.checkHistoryTabActivity(true, "History tab is not shown active");
        mySpaceStep.horizontalSwipe("right", driver);
        mySpaceStep.checkUpcomingTabVisibility(true, "Upcoming tab is not displaying");
        mySpaceStep.checkUpcomingTabActivity(true, "Upcoming tab is not shown active");
        authorizationStep.checkAll();
    }
}
