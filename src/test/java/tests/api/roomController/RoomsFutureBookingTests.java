package tests.api.roomController;
import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static api.core.ApiEndpoints.*;
import static org.assertj.core.api.Assertions.assertThat;



public class RoomsFutureBookingTests {

    private MeetingRoomClient meetingRoomClient;
    private Map<String, Object> query;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        query = new HashMap<>();
        query.put("title","Red");

    }

    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about rooms booked in the future")
    @Description("Get information about available booked in the future")
    public void roomsBookedInTheFuture() {

        JSONObject responseRoomsFutureBooked = meetingRoomClient.getCallQuery(ROOMS_EVENTS_IN_ROOMS, query);
        SoftAssert asserts = new SoftAssert();
        assertThat(responseRoomsFutureBooked.getInt("Status Code")).isEqualTo(200);
        asserts.assertEquals(responseRoomsFutureBooked.getJSONArray("Body").getJSONObject(0).getString("title"), "Red");
        asserts.assertEquals(responseRoomsFutureBooked.getJSONArray("Body").getJSONObject(0).get("board").toString(), "false");
        asserts.assertEquals(responseRoomsFutureBooked.getJSONArray("Body").getJSONObject(0).getString("color"), "#FF0000");
        asserts.assertAll();

    }
}
