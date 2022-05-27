package tests.api;

import api.core.MeetingRoomClient;
import api.dto.ListOfOfficesResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static api.core.ApiEndpoints.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GetListOfOffices  {

    private MeetingRoomClient meetingRoomClient;
    private ListOfOfficesResponse listOfOfficesResponse;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        listOfOfficesResponse = new ListOfOfficesResponse();

    }

    @Owner(value = "Kudayeu S.")
    @Test(description = "Get information about all offices ")
    @Description("Get information about all offices")
    public void getListOfOffices() {

        JSONObject responseGetListOffices = meetingRoomClient.getCall(OFFICES);
        assertThat(responseGetListOffices.getInt("Status Code")).isEqualTo(200);
        ArrayList list1 = new ArrayList(responseGetListOffices.toMap().values());
        String myjson =  list1.get(1).toString();
        String secondJson = listOfOfficesResponse.getJsonListOffices();
        Assert.assertEquals(myjson, secondJson);
    }
}
