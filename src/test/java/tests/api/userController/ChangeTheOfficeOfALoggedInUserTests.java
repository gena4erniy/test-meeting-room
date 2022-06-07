package tests.api.userController;

import api.core.MeetingRoomClientSecond;
import api.dto.OfficeIdDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static api.core.ApiEndpoints.USERS_ME;
import static api.core.ApiEndpoints.USERS_ME_OFFICE;
import static org.assertj.core.api.Assertions.assertThat;


public class ChangeTheOfficeOfALoggedInUserTests {
    private MeetingRoomClientSecond meetingRoomClientSecond;
    private Integer beforeOffice;
    private Integer afterOffice;
    private Integer idOffice;

    @BeforeClass
    private void preconditions() {
        meetingRoomClientSecond = new MeetingRoomClientSecond();
        meetingRoomClientSecond.getAccessTokenSecond();
        JSONObject responseGetInfoAuthUser = meetingRoomClientSecond.getCall(USERS_ME);
        beforeOffice = responseGetInfoAuthUser.getInt("userOfficeId");
        idOffice = getRandomNumberInts();
        while (idOffice.equals(beforeOffice)) {
            idOffice = getRandomNumberInts();
        }

    }

    public static int getRandomNumberInts() {
        Random random = new Random();
        return random.ints(1, (3 + 1)).findFirst().getAsInt();
    }

    @Owner(value = "Golcova A.")
    @Test(description = "Checking changes to the logged-in user's office.")
    @Description("Checking changes to the logged-in user's office.")
    public void patchOfficeId() {

        JSONObject responsePatchOfficeId = meetingRoomClientSecond.patchCall(USERS_ME_OFFICE, OfficeIdDto.builder().build().createOfficeIdBody(idOffice));
        assertThat(responsePatchOfficeId.get("Status Code")).isEqualTo(204);
        JSONObject responseGetInfoAuthUser = meetingRoomClientSecond.getCall(USERS_ME);
        afterOffice = responseGetInfoAuthUser.getInt("userOfficeId");
        Assert.assertNotEquals(beforeOffice, afterOffice);
    }
}
