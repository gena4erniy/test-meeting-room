package tests.api.event.controller;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import helpers.DateTimeHelper;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.EVENTS;
import static ui.constants.Codes.ERROR_BAD_REQUEST;
import static ui.constants.Codes.ERROR_NOT_ACCEPTABLE;

public class CreateEventsNegativeTests {

    private MeetingRoomClient meetingRoomClient;
    private DateTimeHelper dateTimeHelper = new DateTimeHelper();
    private String errorDateTimeMessage = "StartDateTime can't be later endDateTime or can't be the same dateTime";
    private String codeAssertMessage = "Expected status code does not match";
    private String errorAssertMessage = "Expected error does not match";

    @BeforeMethod
    public void beforeMethod() {
        meetingRoomClient = new MeetingRoomClient();
    }

    @DataProvider(name = "Creating data with invalid date time")
    public Object[][] createDataInvalidDateTime() {
        return new Object[][]{
                {dateTimeHelper.getDateTime("tomorrow", 7, 0), dateTimeHelper.getDateTime("tomorrow", 7, 0),
                        "Status Code", ERROR_NOT_ACCEPTABLE.getCode(), codeAssertMessage,
                        "message", errorDateTimeMessage, errorAssertMessage},
                {dateTimeHelper.getDateTime("tomorrow", 7, 0), dateTimeHelper.getDateTime("tomorrow", 6, 0),
                        "Status Code", ERROR_NOT_ACCEPTABLE.getCode(), codeAssertMessage,
                        "message", errorDateTimeMessage, errorAssertMessage},
                {"", dateTimeHelper.getDateTime("tomorrow", 6, 0),
                        "status", ERROR_BAD_REQUEST.getCode(), codeAssertMessage,
                        "error", ERROR_BAD_REQUEST.getDescription(), errorAssertMessage},
                {dateTimeHelper.getDateTime("tomorrow", 7, 0), "",
                        "status", ERROR_BAD_REQUEST.getCode(), codeAssertMessage,
                        "error", ERROR_BAD_REQUEST.getDescription(), errorAssertMessage},
        };
    }

    @Owner("Danilenko D.")
    @Test(description = "Error creating events with invalid date time", dataProvider = "Creating data with invalid date time")
    public void errorCreatingEventsWithInvalidDateTime(String startDateTime, String endDateTime,
                                                       String bodyCode, String code, String codeAssertMessage,
                                                       String bodyMessage, String description, String errorAssertMessage) {
        meetingRoomClient.getAccessToken();
        JSONObject eventDto = EventDto.builder()
                .description("AutoTestDescription")
                .title("AutoTestTitle")
                .build()
                .createEventBody(startDateTime, endDateTime);
        JSONObject responseCreateEvents = meetingRoomClient.postCall(EVENTS, eventDto);
        VerifySoft.verifyEqualsSoft(responseCreateEvents.get(bodyCode).toString(), code, codeAssertMessage);
        VerifySoft.verifyEqualsSoft(responseCreateEvents.get(bodyMessage).toString(), description, errorAssertMessage);
        VerifySoft.showAllChecking();
    }
}
