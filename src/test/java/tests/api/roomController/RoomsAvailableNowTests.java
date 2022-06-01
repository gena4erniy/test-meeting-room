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

public class RoomsAvailableNowTests {

    private MeetingRoomClient meetingRoomClient;
    private Map<String, Object> query;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        query = new HashMap<>();
        query.put("time","ROOMS_AVAILABLE_RIGHT_NOW");

    }

    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about rooms available right now")
    @Description("Get information about available rooms at these moment")
    public void roomsAvailableNow() {

        JSONObject responseGetRoomsAvailableNow = meetingRoomClient.getCallQuery(ROOMS_ACTIVE, query);
        SoftAssert asserts = new SoftAssert();
        assertThat(responseGetRoomsAvailableNow.getInt("Status Code")).isEqualTo(200);
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).get("id"), 3);
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).getString("title"), "Red");
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).getString("office"), "Gomel");
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).get("floor"), 3);
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).get("capacity"), 2);
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).get("projector").toString(), "false");
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).get("board").toString(), "false");
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).get("color"), "#FF0000");
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).getInt("availableIn"), 0);
        asserts.assertEquals(responseGetRoomsAvailableNow.getJSONArray("Body").getJSONObject(0).getInt("timeUntilNextEvent"), 0);
        asserts.assertAll();
    }

}
