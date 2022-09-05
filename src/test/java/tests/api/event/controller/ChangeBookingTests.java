package tests.api.event.controller;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import api.dto.PatchEventDto;
import db.DataBaseManager;
import helpers.DateTimeHelper;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.EVENTS;
import static ui.constants.Codes.ERROR_BAD_REQUEST;
import static ui.constants.Codes.SUCCESS_NO_CONTENT;

public class ChangeBookingTests {

    private MeetingRoomClient meetingRoomClient;
    private DateTimeHelper dateTimeHelper = new DateTimeHelper();
    private JSONObject responseCreateEvents;
    private String description = "AutoTestDescription";
    private String title = "AutoTestTitle";
    private String id;

    @BeforeMethod
    public void beforeMethod() {
        DataBaseManager.createConnection();
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        JSONObject eventDto = EventDto.builder()
                .description(description + "1")
                .title(title + "1")
                .build()
                .createEventBody(dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0));
        responseCreateEvents = meetingRoomClient.postCall(EVENTS, eventDto);
        id = responseCreateEvents.get("id").toString();
        DataBaseManager.addId(id);
    }

    @DataProvider(name = "Create data for change booking")
    public Object[][] createDataForChangeBooking() {
        return new Object[][]{
                {description, title, 1, dateTimeHelper.getDateTime("tomorrow", 8, 0),
                        dateTimeHelper.getDateTime("tomorrow", 9, 0)},
                {null, title, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {description, null, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {"New " + description, title, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {description, "New " + title, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {description, title, 2, dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0)},
        };
    }

    @Owner("Danilenko D.")
    @Test(description = "Change booking with valid data", dataProvider = "Create data for change booking")
    public void changeBookingWithValidData(String description, String title, int roomId, String startDateTime, String endDateTime) {
        JSONObject patchEventDto = PatchEventDto.builder()
                .description(description)
                .title(title)
                .roomId(roomId)
                .build()
                .createPatchEventBody(startDateTime, Integer.parseInt(id), endDateTime);
        JSONObject responsePatchEvents = meetingRoomClient.patchCall(EVENTS, patchEventDto);
        VerifySoft.verifyEqualsSoft(responsePatchEvents.get("Status Code").toString(), SUCCESS_NO_CONTENT.getCode(),
                "Expected status code does not match");
        VerifySoft.verifyEqualsSoft(DataBaseManager.getEventStatusById(id), "ACTIVE",
                "Expected event status does not match");
        VerifySoft.showAllChecking();
    }

    @DataProvider(name = "Create data for change booking negative")
    public Object[][] createDataForChangeBookingNegative() {
        return new Object[][]{
                {description, title, 1, null, dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {description, title, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0), null},
                {description, title, 1, "", dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {description, title, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0), ""},
                {description, title, 1, "qwe", dateTimeHelper.getDateTime("tomorrow", 8, 0)},
                {description, title, 1, dateTimeHelper.getDateTime("tomorrow", 7, 0), "qwe"},
        };
    }

    @Owner("Danilenko D.")
    @Test(description = "Error change booking with invalid data", dataProvider = "Create data for change booking negative")
    public void errorChangeBookingWithInvalidData(String description, String title, int roomId, String startDateTime, String endDateTime) {
        JSONObject patchEventDto = PatchEventDto.builder()
                .description(description)
                .title(title)
                .roomId(roomId)
                .build()
                .createPatchEventBody(startDateTime, Integer.parseInt(id), endDateTime);
        JSONObject responsePatchEvents = meetingRoomClient.patchCall(EVENTS, patchEventDto);
        VerifySoft.verifyEqualsSoft(responsePatchEvents.get("status").toString(), ERROR_BAD_REQUEST.getCode(),
                "Expected status code does not match");
        VerifySoft.verifyEqualsSoft(responsePatchEvents.get("error").toString(), ERROR_BAD_REQUEST.getDescription(),
                "Expected error does not match");
        VerifySoft.showAllChecking();
    }

    @AfterMethod
    public void afterMethod() {
        DataBaseManager.deleteEvents(DataBaseManager.getAllIds());
        DataBaseManager.closeConnection();
    }
}
