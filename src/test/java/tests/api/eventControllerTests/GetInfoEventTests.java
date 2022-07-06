package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import db.DataBaseDelete;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.core.ApiEndpoints.EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetInfoEventTests {
    private MeetingRoomClient meetingRoomClient;
    private JSONObject eventDto;
    private DataBaseDelete dataBaseDelete;
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
        eventDto = EventDto.builder().description("dff").title("red").build().createEventBody(startDateTime, endDateTime);
        JSONObject responseGetInfoCreateEvent = meetingRoomClient.postCall(EVENTS, eventDto);
        id = responseGetInfoCreateEvent.getInt("id");

    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information about event")
    @Description("Create event")
    public void getInfoEvent() {
        JSONObject responseGetInfoCreateRegularEvent = meetingRoomClient.getCall(EVENTS + "/" + id);
        Assertions.assertThat(responseGetInfoCreateRegularEvent.getInt("Status Code")).isEqualTo(200);
        Assert.assertEquals(responseGetInfoCreateRegularEvent.get("id"), id);
        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoCreateRegularEvent.getString("title"), "red");
        asserts.assertEquals(responseGetInfoCreateRegularEvent.getString("description"), "dff");
        assertThat(responseGetInfoCreateRegularEvent.get("room")).isNotNull();
        assertThat(responseGetInfoCreateRegularEvent.get("user")).isNotNull();
        assertThat(responseGetInfoCreateRegularEvent.get("status")).isNotNull();
        asserts.assertEquals(responseGetInfoCreateRegularEvent.getString("status"), "BOOKED");
        asserts.assertAll();
    }

    @AfterClass
    public void deleteBookingByIdDataBase() throws SQLException {
        dataBaseDelete = new DataBaseDelete();
        dataBaseDelete.deleteEvenDataBase(id);
    }
}

