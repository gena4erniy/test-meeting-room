package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import api.dto.PatchEventDto;
import db.DataBase;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.core.ApiEndpoints.EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PatchEventTests {
    private MeetingRoomClient meetingRoomClient;
    private DataBase dataBase;
    private JSONObject eventDto;
    private JSONObject patchEventDto;
    private Integer id;
    private String pattern = "yyyy-MM-dd'T'kk:mm:ss.SSS";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private Date DateTime = addHoursToJavaUtilDate(new Date(System.currentTimeMillis()), 1);
    private String startDateTime = simpleDateFormat.format(DateTime);
    private String endDateTime = simpleDateFormat.format(addHoursToJavaUtilDate(DateTime, 1));
    private String beforeDescription;
    private String afterDescription;


    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        eventDto = EventDto.builder().description("New").title("event").build().createEventBody(startDateTime, endDateTime);
        JSONObject responseGetInfoCreateEvent = meetingRoomClient.postCall(EVENTS, eventDto);
        id = responseGetInfoCreateEvent.getInt("id");
        JSONObject responseGetEventInformationById = meetingRoomClient.getCall(EVENTS + "/" + id);
        beforeDescription = responseGetEventInformationById.getString("description");
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }


    @Owner(value = "Golcova A.")
    @Test(description = "Checking booking changes.")
    @Description("Checking booking changes.")
    public void changeBooking() {
        patchEventDto = PatchEventDto.builder().description("Patch").roomId(2).title("event").build().createPatchEventBody(startDateTime, id, endDateTime);
        JSONObject responsePatchEvent = meetingRoomClient.patchCall(EVENTS, patchEventDto);
        assertThat(responsePatchEvent.getInt("Status Code")).isEqualTo(204);
        JSONObject responseGetEventInformationById = meetingRoomClient.getCall(EVENTS + "/" + id);
        afterDescription = responseGetEventInformationById.getString("description");
        Assert.assertNotEquals(afterDescription, beforeDescription);
    }


    @AfterClass
    public void deleteBookingByIdDataBase() throws SQLException {
        dataBase = new DataBase();
        dataBase.delete(id);
    }
}
