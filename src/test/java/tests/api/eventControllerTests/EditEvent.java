package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.LoginRequestDto;
import api.dto.NewEventDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.core.ApiEndpoints.EVENTS;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class EditEvent {
    private MeetingRoomClient meetingRoomClient;
    private JSONObject loginRequestDto;
    private JSONObject eventDto;
    private JSONObject newEventDto;

    @Ignore
    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL).password(VALID_PASS).build().createBody();
        newEventDto = NewEventDto.builder().description("asd").title("red").build().createNewEventBody();
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information about edit event")
    @Description("edit event")
    public void checkEditEvent() {
        JSONObject responseGetInfoCreateEvent = meetingRoomClient.patchCall(EVENTS, newEventDto);

        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoCreateEvent.getInt("roomId"), 1);
        asserts.assertEquals(responseGetInfoCreateEvent.getInt("id"), 3569);
        asserts.assertEquals(responseGetInfoCreateEvent.getString("endDateTime"), "2022-05-27T19:53:47.439");
        asserts.assertEquals(responseGetInfoCreateEvent.getString("startDateTime"), "2022-05-27T17:53:47.439");
        asserts.assertAll();
    }
}

