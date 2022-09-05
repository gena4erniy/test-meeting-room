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
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.EVENTS;
import static ui.constants.Codes.SUCCESS_NO_CONTENT;

public class BookingEventConfirmationTests {

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
                .description(description)
                .title(title)
                .build()
                .createEventBody(dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0));
        responseCreateEvents = meetingRoomClient.postCall(EVENTS, eventDto);
        id = responseCreateEvents.get("id").toString();
        DataBaseManager.addId(id);
    }

    @Owner("Danilenko D.")
    @Test(description = "Confirmation booking event")
    public void confirmationBookingEvent() {
        JSONObject patchEventDto = PatchEventDto.builder()
                .description(description)
                .title(title)
                .roomId(1)
                .build()
                .createPatchEventBody(responseCreateEvents.get("startDateTime").toString(), Integer.parseInt(id),
                        responseCreateEvents.get("endDateTime").toString());
        JSONObject responsePatchEvents = meetingRoomClient.patchCall(EVENTS, patchEventDto);
        VerifySoft.verifyEqualsSoft(responsePatchEvents.get("Status Code").toString(), SUCCESS_NO_CONTENT.getCode(),
                "Expected status code does not match");
        VerifySoft.verifyEqualsSoft(DataBaseManager.getEventStatusById(id), "ACTIVE",
                "Expected event status does not match");
        VerifySoft.showAllChecking();
    }

    @AfterMethod
    public void afterMethod() {
        DataBaseManager.deleteEvents(DataBaseManager.getAllIds());
        DataBaseManager.closeConnection();
    }
}
