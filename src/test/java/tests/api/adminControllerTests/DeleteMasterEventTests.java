package tests.api.adminControllerTests;

import api.core.MeetingRoomAdmin;
import api.dto.EventDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.core.ApiEndpoints.ADMIN_EVENTS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DeleteMasterEventTests {
    private MeetingRoomAdmin meetingRoomAdmin;
    private JSONObject eventDto;
    private String pattern = "yyyy-MM-dd'T'kk:mm:ss.SSS";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private Date DateTime = addHoursToJavaUtilDate(new Date(System.currentTimeMillis()), 1);
    private String startDateTime = simpleDateFormat.format(DateTime);
    private String endDateTime = simpleDateFormat.format(addHoursToJavaUtilDate(DateTime, 1));
    private Integer id;

    @BeforeClass
    private void preconditions() {
        meetingRoomAdmin = new MeetingRoomAdmin();
        meetingRoomAdmin.getAccessToken();
        eventDto = EventDto.builder().description("dff").title("red").build().createEventBody(startDateTime, endDateTime);
        JSONObject responceGetInfoCreateMasterEvent = meetingRoomAdmin.postCall(ADMIN_EVENTS, eventDto);
        id = responceGetInfoCreateMasterEvent.getInt("id");
    }

    @Owner(value = "Sirozh E.")
    @Test(description = "Get information about status delete in event")
    @Description("Delete event")
    public void getInfoDelete() {
        JSONObject responceDeleteMasterEvent = meetingRoomAdmin.deleteCall(ADMIN_EVENTS + "/" + id);
        assertThat(responceDeleteMasterEvent.getInt("Status Code")).isEqualTo(204);
        JSONObject responseGetInfoDeleteMasterEvent= meetingRoomAdmin.getCall(ADMIN_EVENTS + "/" + id);
        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoDeleteMasterEvent.getInt("status"), "DELETED");
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}