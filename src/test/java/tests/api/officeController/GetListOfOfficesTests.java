package tests.api.officeController;

import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.core.ApiEndpoints.OFFICES;
import static org.assertj.core.api.Assertions.assertThat;

public class GetListOfOfficesTests {

    private MeetingRoomClient meetingRoomClient;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();

    }

    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about all offices ")
    @Description("Get information about all offices")
    public void getListOfOffices() {

        JSONArray array = new JSONArray();
        array.put("White");
        array.put("Black");
        JSONObject responseGetListOffices = meetingRoomClient.getCall(OFFICES);
        SoftAssert asserts = new SoftAssert();
        assertThat(responseGetListOffices.get("Status Code")).isEqualTo(200);
        asserts.assertEquals(responseGetListOffices.getJSONArray("Body").getJSONObject(0).get("id"), 1);
        asserts.assertEquals(responseGetListOffices.getJSONArray("Body").getJSONObject(0).get("country"), "Belarus");
        asserts.assertEquals(responseGetListOffices.getJSONArray("Body").getJSONObject(0).get("city"), "Minsk");
        asserts.assertEquals(responseGetListOffices.getJSONArray("Body").getJSONObject(0)
                .get("rooms").toString(), array.toString());
        asserts.assertAll();
    }
}
