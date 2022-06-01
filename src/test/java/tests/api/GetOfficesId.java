package tests.api;

import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import static api.core.ApiEndpoints.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GetOfficesId {

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

        JSONObject responseGetOfficeId = meetingRoomClient.getCall(OFFICES_PARAM3);
        assertThat(responseGetOfficeId.getInt("Status Code")).isEqualTo(200);

        assertThat(responseGetOfficeId.get("rooms").toString()).isEqualTo("[\"Yellow\",\"Orange\",\"Gray\"]");
        assertThat(responseGetOfficeId.getInt("id")).isEqualTo(3);
        assertThat(responseGetOfficeId.getString("country")).isEqualTo("Russia");
        assertThat(responseGetOfficeId.getString("city")).isEqualTo("Saint Petersburg");
        assertThat(responseGetOfficeId.get("timezone").toString()).isEqualTo("null");
    }
}
