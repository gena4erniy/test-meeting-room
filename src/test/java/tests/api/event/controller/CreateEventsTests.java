package tests.api.event.controller;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import db.DataBaseManager;
import helpers.DateTimeHelper;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.EVENTS;
import static ui.constants.Codes.ERROR_UNAUTHORIZED;

public class CreateEventsTests {

    private MeetingRoomClient meetingRoomClient;
    private DateTimeHelper dateTimeHelper = new DateTimeHelper();

    @BeforeMethod
    public void beforeMethod() {
        DataBaseManager.createConnection();
        meetingRoomClient = new MeetingRoomClient();
    }

    @Owner("Danilenko D.")
    @Test(description = "Creating event")
    public void creatingEvent() {
        meetingRoomClient.getAccessToken();
        JSONObject eventDto = EventDto.builder()
                .description("AutoTestDescription")
                .title("AutoTestTitle")
                .build()
                .createEventBody(dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        dateTimeHelper.getDateTime("tomorrow", 8, 0));
        JSONObject responseCreateEvents = meetingRoomClient.postCall(EVENTS, eventDto);
        String id = responseCreateEvents.get("id").toString();
        DataBaseManager.addId(id);
        VerifySoft.verifyEqualsSoft(responseCreateEvents.get("Status Code").toString(), "201",
                "Expected status code does not match");
        VerifySoft.verifyEqualsSoft(DataBaseManager.getEventStatusById(id), "BOOKED",
                "Expected event status does not match");
        VerifySoft.showAllChecking();
    }

    @Owner("Danilenko D.")
    @Test(description = "Error creating events without token")
    public void errorCreatingEventsWithoutToken() {
        JSONObject eventDto = EventDto.builder()
                .description("AutoTestDescription")
                .title("AutoTestTitle")
                .build()
                .createEventBody(dateTimeHelper.getDateTime("tomorrow", 7, 0), dateTimeHelper.getDateTime("tomorrow", 7, 0));
        JSONObject responseCreateEvents = meetingRoomClient.postCall(EVENTS, eventDto);
        VerifySoft.verifyEqualsSoft(responseCreateEvents.get("Status Code").toString(), ERROR_UNAUTHORIZED.getCode(),
                "Expected status code does not match");
        VerifySoft.showAllChecking();
    }

    @AfterMethod()
    public void afterMethod() {
        DataBaseManager.deleteEvents(DataBaseManager.getAllIds());
        DataBaseManager.closeConnection();
    }
}
