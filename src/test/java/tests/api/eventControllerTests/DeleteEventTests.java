package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import api.dto.LoginRequestDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.core.ApiEndpoints.EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class DeleteEventTests {
    private MeetingRoomClient meetingRoomClient;
    private JSONObject loginRequestDto;
    private JSONObject eventDto;
    private String startDateTime = "2022-05-27T17:53:47.439";
    private String endDateTime = "2022-05-27T19:53:47.439";

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        eventDto = EventDto.builder().description("dff").title("red").build().createEventBody(startDateTime, endDateTime);
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information create event")
    @Description("create event")
    public void getInfoDeleteEvent() {
        JSONObject responseGetInfoAuthUser = meetingRoomClient.deleteCall("api/events/3569" , eventDto);
        Assertions.assertThat(responseGetInfoAuthUser.getInt("Status Code")).isEqualTo(204);

//        SoftAssert asserts = new SoftAssert();
//        asserts.assertEquals(responseGetInfoAuthUser.getInt("id"), 3569);
//        asserts.assertEquals(responseGetInfoAuthUser.getString("title"), "red");
//        assertThat(responseGetInfoAuthUser.get("room")).isNotNull();
//        assertThat(responseGetInfoAuthUser.get("user")).isNotNull();
//        asserts.assertAll();
    }
}
//{
//        "id": 3589,
//        "startDateTime": "2022-06-01T13:18:51.35",
//        "endDateTime": "2022-06-01T14:18:51.35",
//        "roomId": 1,
//        "type": "REGULAR_EVENT"
//        }