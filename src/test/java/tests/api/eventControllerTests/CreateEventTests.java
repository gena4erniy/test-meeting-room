package tests.api.eventControllerTests;

import api.core.MeetingRoomClient;
import api.dto.EventDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static api.core.ApiEndpoints.EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateEventTests {
    private MeetingRoomClient meetingRoomClient;
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
        eventDto = EventDto.builder().description("dff").title("red").build().createEventBody(startDateTime, endDateTime);
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information about create test")
    @Description("Create regular event")
    public void getInfoCreateEvent() {
        JSONObject responseGetInfoCreateEvent = meetingRoomClient.postCall(EVENTS, eventDto);
        assertThat(responseGetInfoCreateEvent.getInt("Status Code")).isEqualTo(201);
        id = responseGetInfoCreateEvent.getInt("id");

        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoCreateEvent.getInt("roomId"), 1);
        asserts.assertEquals(responseGetInfoCreateEvent.getString("endDateTime"), endDateTime);
        asserts.assertEquals(responseGetInfoCreateEvent.getString("startDateTime"), startDateTime);
        asserts.assertAll();
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    @AfterClass
    public void deleteBookingById() {
        meetingRoomClient.deleteCall(EVENTS + "/" + id);

    }
}