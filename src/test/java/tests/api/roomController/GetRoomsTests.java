package tests.api.roomController;
import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static api.core.ApiEndpoints.*;
import static org.assertj.core.api.Assertions.assertThat;
public class GetRoomsTests {
    private MeetingRoomClient meetingRoomClient;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();

    }

    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about rooms")
    @Description("Get information about all available rooms")
    public void getListOfRooms() {

        JSONObject responseGetListRooms = meetingRoomClient.getCall(ROOMS);
        SoftAssert asserts = new SoftAssert();
        assertThat(responseGetListRooms.getInt("Status Code")).isEqualTo(200);
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).get("id"), 1);
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).getString("title"), "White");
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).getString("office"), "Minsk");
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).get("floor"), 3);
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).get("capacity"), 2);
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).get("projector").toString(), "true");
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).get("board").toString(), "true");
        asserts.assertEquals(responseGetListRooms.getJSONArray("Body").getJSONObject(0).get("color"), "#FFFFFF");
        asserts.assertAll();
    }
}
