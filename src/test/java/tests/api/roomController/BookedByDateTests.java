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

import static api.core.ApiEndpoints.ROOMS_EVENTS;
import static org.assertj.core.api.Assertions.assertThat;

public class BookedByDateTests {

    private MeetingRoomClient meetingRoomClient;
    private Map<String, Object> query;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        query = new HashMap<>();
        query.put("day", "2022-07-15");

    }
    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about rooms available at certain date")
    @Description("Get information about rooms available at certain date")
    public void roomsAvailableDate() {

        JSONObject responseGetRoomsAvailableDate = meetingRoomClient.getCallQuery(ROOMS_EVENTS, query);
        SoftAssert asserts = new SoftAssert();
        assertThat(responseGetRoomsAvailableDate.getInt("Status Code")).isEqualTo(200);
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).get("id"), 3);
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).getString("title"), "Red");
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).getString("office"), "Gomel");
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).get("floor"), 3);
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).get("projector").toString(), "false");
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).get("board").toString(), "false");
        asserts.assertEquals(responseGetRoomsAvailableDate.getJSONArray("Body").getJSONObject(0).get("color"), "#FF0000");
        asserts.assertAll();

    }
}
