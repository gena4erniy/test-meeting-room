package tests.api.officeController;

import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.core.ApiEndpoints.OFFICES_PARAM3;
import static org.assertj.core.api.Assertions.assertThat;

public class GetOfficesIdTests {

    private MeetingRoomClient meetingRoomClient;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
    }

    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about office using ID")
    @Description("Get information about office using ID")
    public void getOfficesId() {
        JSONArray array = new JSONArray();
        array.put("Yellow");
        array.put("Orange");
        array.put("Gray");

        JSONObject responseGetOfficeId = meetingRoomClient.getCall(OFFICES_PARAM3);
        assertThat(responseGetOfficeId.getInt("Status Code")).isEqualTo(200);

        assertThat(responseGetOfficeId.getInt("id")).isEqualTo(3);
        assertThat(responseGetOfficeId.getString("country")).isEqualTo("Russia");
        assertThat(responseGetOfficeId.getString("city")).isEqualTo("Saint Petersburg");
    }
}
