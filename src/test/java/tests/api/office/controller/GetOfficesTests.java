package tests.api.office.controller;

import api.core.MeetingRoomClient;
import db.DataBaseManager;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.OFFICES;
import static ui.constants.Codes.ERROR_UNAUTHORIZED;
import static ui.constants.Codes.SUCCESS_OK;

public class GetOfficesTests {

    private MeetingRoomClient meetingRoomClient;

    @BeforeMethod
    public void beforeMethod() {
        DataBaseManager.createConnection();
        meetingRoomClient = new MeetingRoomClient();
    }

    @Owner("Danilenko D.")
    @Test(description = "Getting list of offices")
    public void gettingListOfOffices() {
        meetingRoomClient.getAccessToken();
        JSONObject responseGetOffices = meetingRoomClient.getCall(OFFICES);
        VerifySoft.verifyEqualsSoft(responseGetOffices.get("Status Code").toString(), SUCCESS_OK.getCode(),
                "Expected status code does not match");
        for (int i = 0; i < responseGetOffices.getJSONArray("Body").length(); i++) {
            String id = responseGetOffices.getJSONArray("Body").getJSONObject(i).get("id").toString();
            VerifySoft.verifyEqualsSoft(responseGetOffices.getJSONArray("Body").getJSONObject(i).get("id").toString(),
                    DataBaseManager.getOfficeById(id, "id"), "Expected id does not match");
            VerifySoft.verifyEqualsSoft(responseGetOffices.getJSONArray("Body").getJSONObject(i).get("country").toString(),
                    DataBaseManager.getOfficeById(id, "country"), "Expected country does not match");
            VerifySoft.verifyEqualsSoft(responseGetOffices.getJSONArray("Body").getJSONObject(i).get("city").toString(),
                    DataBaseManager.getOfficeById(id, "city"), "Expected city does not match");
            VerifySoft.verifyEqualsSoft(responseGetOffices.getJSONArray("Body").getJSONObject(i).get("timezone").toString(),
                    DataBaseManager.getOfficeById(id, "timezone"), "Expected timezone does not match");
        }
        VerifySoft.showAllChecking();
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting list of offices without token")
    public void errorGettingListOfOfficesWithoutToken() {
        JSONObject responseGetOffices = meetingRoomClient.getCall(OFFICES);
        VerifySoft.verifyEqualsSoft(responseGetOffices.get("Status Code").toString(), ERROR_UNAUTHORIZED.getCode(),
                "Expected status code does not match");
        VerifySoft.showAllChecking();
    }

    @AfterMethod
    public void afterMethod() {
        DataBaseManager.closeConnection();
    }
}
