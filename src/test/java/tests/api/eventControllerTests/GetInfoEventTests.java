package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetInfoEventTests {
    private MeetingRoomClient meetingRoomClient;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information about event")
    @Description("Create event")
    public void getInfoEvent() {
        JSONObject responseGetInfoCreateRegularEvent = meetingRoomClient.getCall("api/events/3565");
        Assertions.assertThat(responseGetInfoCreateRegularEvent.getInt("Status Code")).isEqualTo(200);

        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoCreateRegularEvent.getInt("id"), 3565);
        asserts.assertEquals(responseGetInfoCreateRegularEvent.getString("title"), "red");
        asserts.assertEquals(responseGetInfoCreateRegularEvent.getString("description"), "dff");
        assertThat(responseGetInfoCreateRegularEvent.get("room")).isNotNull();
        assertThat(responseGetInfoCreateRegularEvent.get("user")).isNotNull();
        assertThat(responseGetInfoCreateRegularEvent.get("status")).isNotNull();
//        asserts.assertEquals(responseGetInfoAuthUser.getString("status"), "BOOKED");
        asserts.assertAll();
    }
}

