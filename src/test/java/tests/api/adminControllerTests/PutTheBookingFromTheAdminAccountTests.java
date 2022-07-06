package tests.api.adminControllerTests;

import api.core.MeetingRoomAdmin;
import api.dto.EventDto;
import api.dto.PutEventDto;
import db.DataBaseDelete;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.core.ApiEndpoints.ADMIN_EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PutTheBookingFromTheAdminAccountTests {
    private MeetingRoomAdmin meetingRoomAdmin;
    private DataBaseDelete dataBaseDelete;
    private Integer id;
    private JSONObject eventDto;
    private JSONObject putEventDto;

    private String pattern = "yyyy-MM-dd'T'kk:mm:ss.SS";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private Date DateTime = addHoursToJavaUtilDate(new Date(System.currentTimeMillis()), 0);
    private String startDateTime = simpleDateFormat.format(DateTime);
    private String endDateTime = simpleDateFormat.format(addHoursToJavaUtilDate(DateTime, 1));

    private Date DateTime2 = addHoursToJavaUtilDate(new Date(System.currentTimeMillis()), 1);
    private String newStartDateTime = simpleDateFormat.format(DateTime2);
    private String newEndDateTime = simpleDateFormat.format(addHoursToJavaUtilDate(DateTime2, 1));


    @BeforeClass
    private void preconditions() {
        meetingRoomAdmin = new MeetingRoomAdmin();
        meetingRoomAdmin.getAccessToken();
        eventDto = EventDto.builder().description("ffd").title("black").build().createEventBody(startDateTime, endDateTime);
        JSONObject responseGetInfoCreateEvent = meetingRoomAdmin.postCall(ADMIN_EVENTS, eventDto);
        id = responseGetInfoCreateEvent.getInt("id");
        putEventDto = PutEventDto.builder().description("put").roomId(2).title("qa").build().createPutEventBody(newStartDateTime, id, newEndDateTime);
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    @Owner(value = "Golcova A.")
    @Test(description = "Checking booking changes from the admin account.")
    @Description("Checking booking changes from the admin account.")
    public void putBookingAdmin() {
        JSONObject responsePutEvent = meetingRoomAdmin.putCall(ADMIN_EVENTS, putEventDto);
        assertThat(responsePutEvent.getInt("Status Code")).isEqualTo(204);
    }

    @AfterClass
    public void deleteBookingByIdDataBase() throws SQLException {
        dataBaseDelete = new DataBaseDelete();
        dataBaseDelete.deleteEvenDataBase(id);
    }
}
