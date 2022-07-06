package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import db.DataBaseDelete;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.core.ApiEndpoints.EVENTS;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBookingByIdTests {
    private MeetingRoomClient meetingRoomClient;
    private DataBaseDelete dataBaseDelete;
    private JSONObject eventDto;
    private Integer id;
    private String pattern = "yyyy-MM-dd'T'kk:mm:ss.SSS";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private Date DateTime = addHoursToJavaUtilDate(new Date(System.currentTimeMillis()), 1);
    private String startDateTime = simpleDateFormat.format(DateTime);
    private String endDateTime = simpleDateFormat.format(addHoursToJavaUtilDate(DateTime, 1));


    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
        eventDto = EventDto.builder().description("New").title("red").build().createEventBody(startDateTime, endDateTime);
        JSONObject responseGetInfoCreateEvent = meetingRoomClient.postCall(EVENTS, eventDto);
        id = responseGetInfoCreateEvent.getInt("id");
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    @Owner(value = "Golcova A.")
    @Test(description = "Checking the deletion of booking by ID.")
    @Description("Checking the deletion of booking by ID.")
    public void deleteBookingById() {
        JSONObject responseDeleteBookingById = meetingRoomClient.deleteCall(EVENTS + "/" + id);
        assertThat(responseDeleteBookingById.getInt("Status Code")).isEqualTo(204);
        JSONObject responseGetEventInformationById = meetingRoomClient.getCall(EVENTS + "/" + id);
        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetEventInformationById.getString("status"), "DELETED");
    }

    @AfterClass
    public void deleteBookingByIdDataBase() throws SQLException {
        dataBaseDelete = new DataBaseDelete();
        dataBaseDelete.deleteEvenDataBase(id);
    }
}
