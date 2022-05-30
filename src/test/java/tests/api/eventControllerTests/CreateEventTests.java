package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import api.dto.LoginRequestDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.core.ApiEndpoints.EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class CreateEventTests {
    private MeetingRoomClient meetingRoomClient;
    private JSONObject loginRequestDto;
    private JSONObject eventDto;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL).password(VALID_PASS).build().createBody();
        eventDto = EventDto.builder().description("dff").title("red").build().createEventBody();

    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information create event")
    @Description("create event")
    public void getInfoCreateEvent() {
        JSONObject responseGetInfoCreateEvent = meetingRoomClient.postCall(EVENTS, eventDto);
        assertThat(responseGetInfoCreateEvent.getInt("Status Code")).isEqualTo(201);

        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoCreateEvent.getInt("roomId"), 1);
        asserts.assertEquals(responseGetInfoCreateEvent.getString("endDateTime"), "2022-05-27T19:53:47.439");
        asserts.assertEquals(responseGetInfoCreateEvent.getString("startDateTime"), "2022-05-27T17:53:47.439");
        asserts.assertAll();
    }
}