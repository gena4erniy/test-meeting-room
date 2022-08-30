package tests.api.office.controller;

import api.core.MeetingRoomClient;
import db.DataBaseManager;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.OFFICES_PARAM;
import static ui.constants.Codes.SUCCESS_OK;

public class GetOfficesByIdTests {

    private MeetingRoomClient meetingRoomClient;

    @BeforeMethod
    public void beforeMethod() {
        DataBaseManager.createConnection();
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
    }

    @Owner("Danilenko D.")
    @Test(description = "Getting offices by id")
    public void gettingOfficesById() {
        JSONObject responseGetOfficeById = meetingRoomClient.getCall(String.format(OFFICES_PARAM, (int) (Math.random() * 4) + 1));
        VerifySoft.verifyEqualsSoft(responseGetOfficeById.get("Status Code").toString(), SUCCESS_OK.getCode(),
                "Expected status code does not match");
        String id = responseGetOfficeById.get("id").toString();
        VerifySoft.verifyEqualsSoft(responseGetOfficeById.get("id").toString(), DataBaseManager.getOfficeById(id, "id"),
                "Expected id does not match");
        VerifySoft.verifyEqualsSoft(responseGetOfficeById.get("country").toString(),
                DataBaseManager.getOfficeById(id, "country"), "Expected country does not match");
        VerifySoft.verifyEqualsSoft(responseGetOfficeById.get("city").toString(),
                DataBaseManager.getOfficeById(id, "city"), "Expected city does not match");
        VerifySoft.verifyEqualsSoft(responseGetOfficeById.get("timezone").toString(),
                DataBaseManager.getOfficeById(id, "timezone"), "Expected timezone does not match");
        VerifySoft.showAllChecking();
    }

    @AfterMethod
    public void afterMethod() {
        DataBaseManager.closeConnection();
    }
}
