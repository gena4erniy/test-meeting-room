package tests.api.adminControllerTests;

import api.core.MeetingRoomAdmin;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.core.ApiEndpoints.ADMIN_ME_EVENTS;

public class GetMeInfoTests {
    private MeetingRoomAdmin meetingRoomAdmin;

    @BeforeClass
    private void preconditions() {
        meetingRoomAdmin = new MeetingRoomAdmin();
        meetingRoomAdmin.getAccessToken();
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information me admin")
    @Description("Info about master event")
    public void getInfoEvent() {
        JSONObject responseGetInfoCreateRegularEvent = meetingRoomAdmin.getCall(ADMIN_ME_EVENTS);
        Assertions.assertThat(responseGetInfoCreateRegularEvent.getInt("Status Code")).isEqualTo(200);
    }
}