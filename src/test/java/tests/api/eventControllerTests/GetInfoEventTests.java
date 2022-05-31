package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.LoginRequestDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class GetInfoEventTests {
    private MeetingRoomClient meetingRoomClient;
    private JSONObject loginRequestDto;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL).password(VALID_PASS).build().createBody();
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information create event")
    @Description("create event")
    public void getInfoEvent() {
        JSONObject responseGetInfoAuthUser = meetingRoomClient.getCall("api/events/3569");
        Assertions.assertThat(responseGetInfoAuthUser.getInt("Status Code")).isEqualTo(200);

        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoAuthUser.getInt("id"), 3569);
        asserts.assertEquals(responseGetInfoAuthUser.getString("title"), "red");
        assertThat(responseGetInfoAuthUser.get("room")).isNotNull();
        assertThat(responseGetInfoAuthUser.get("user")).isNotNull();
        asserts.assertAll();
    }
}

