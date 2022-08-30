package tests.api.office.controller;

import api.core.MeetingRoomClient;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.OFFICES_PARAM;
import static ui.constants.Codes.*;

public class GetOfficesByIdNegativeTests {

    private MeetingRoomClient meetingRoomClient;
    private String codeAssertMessage = "Expected status code does not match";
    private String errorAssertMessage = "Expected error does not match";

    @BeforeMethod
    public void beforeMethod() {
        meetingRoomClient = new MeetingRoomClient();
    }

    @DataProvider(name = "Creating data with invalid id")
    public Object[][] createDataInvalidId() {
        return new Object[][]{
                {"null", "status", ERROR_BAD_REQUEST.getCode(), codeAssertMessage, 
                        "error", ERROR_BAD_REQUEST.getDescription(), errorAssertMessage},
                {"1.", "status", ERROR_BAD_REQUEST.getCode(), codeAssertMessage,
                        "error", ERROR_BAD_REQUEST.getDescription(), errorAssertMessage},
                {"qwe", "status", ERROR_BAD_REQUEST.getCode(), codeAssertMessage,
                        "error", ERROR_BAD_REQUEST.getDescription(), errorAssertMessage},
                {"0", "error", ERROR_NOT_FOUND.getCode(), codeAssertMessage,
                        "message", "Office not found", "Expected message does not match"}
        };
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting offices with invalid id", dataProvider = "Creating data with invalid id")
    public void errorGettingOfficesWithInvalidId(String id, String bodyCode, String code, String codeAssertMessage,
                                                 String bodyMessage, String description, String errorAssertMessage) {
        meetingRoomClient.getAccessToken();
        JSONObject responseGetOffices = meetingRoomClient.getCall(String.format(OFFICES_PARAM, id));
        VerifySoft.verifyEqualsSoft(responseGetOffices.get(bodyCode).toString(), code, codeAssertMessage);
        VerifySoft.verifyEqualsSoft(responseGetOffices.get(bodyMessage).toString(), description, errorAssertMessage);
        VerifySoft.showAllChecking();
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting offices by id without token")
    public void errorGettingOfficesByIdWithoutToken() {
        JSONObject responseGetOffices = meetingRoomClient.getCall(String.format(OFFICES_PARAM, 1));
        VerifySoft.verifyEqualsSoft(responseGetOffices.get("Status Code").toString(), ERROR_UNAUTHORIZED.getCode(),
                "Expected status code does not match");
        VerifySoft.showAllChecking();
    }
}
