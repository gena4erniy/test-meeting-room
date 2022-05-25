package tests.api;

import api.core.MeetingRoomClient;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static api.core.ApiEndpoints.USERS_ME;
import static org.assertj.core.api.Assertions.assertThat;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;

public class GetInfoAuthUserTests {
    private MeetingRoomClient meetingRoomClient;

    @BeforeClass
    private void preconditions() {
        meetingRoomClient = new MeetingRoomClient();
        meetingRoomClient.getAccessToken();
    }

    @Owner(value = "Kurchenko V.")
    @Test(description = "Get information about a logged in user")
    @Description("Get information about a logged in user")
    public void getInfoAuthUser() {

        JSONObject responseGetInfoAuthUser = meetingRoomClient.getCall(USERS_ME);
        assertThat(responseGetInfoAuthUser.getInt("Status Code")).isEqualTo(200);

        SoftAssert asserts = new SoftAssert();
        asserts.assertEquals(responseGetInfoAuthUser.getInt("id"), "sss");
        asserts.assertEquals(responseGetInfoAuthUser.getString("email"), VALID_MAIL);
        asserts.assertEquals(responseGetInfoAuthUser.getString("name"), "Andrei");
        asserts.assertEquals(responseGetInfoAuthUser.getString("position"), "PM");
        asserts.assertEquals(responseGetInfoAuthUser.getString("role"), "ROLE_USER");
        asserts.assertEquals(responseGetInfoAuthUser.getString("skype"), "live:.cid.11111");
        asserts.assertEquals(responseGetInfoAuthUser.getString("surname"), "Dashkevich");
        asserts.assertEquals(responseGetInfoAuthUser.getString("username"), "user1");
        asserts.assertEquals(responseGetInfoAuthUser.getString("officeCountry"), "Belarus");
        asserts.assertEquals(responseGetInfoAuthUser.getString("officeCity"), "Gomel");
        asserts.assertEquals(responseGetInfoAuthUser.get("adminOfficeId"), null);
        asserts.assertEquals(responseGetInfoAuthUser.get("userOfficeId"), 2);
        asserts.assertAll();
    }
}