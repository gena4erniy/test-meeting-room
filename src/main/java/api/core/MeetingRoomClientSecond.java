package api.core;

import api.dto.LoginRequestDto;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static api.core.ApiEndpoints.AUTH_SIGNIN;
import static org.assertj.core.api.Assertions.assertThat;
import static ui.constants.Constant.ValidCredo2.VALID_MAIL2;
import static ui.constants.Constant.ValidCredo2.VALID_PASS2;

public class MeetingRoomClientSecond extends BaseApiClient {
    private String accessToken;

    public String url = "https://meetingroom.andersenlab.dev/";

    @Override
    protected String getBaseURL() {
        return url;
    }

    @Override
    protected RequestSpecification request() {
        return super.request()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .header("charset", "utf-8")
                .header("User-Agent", "Passport-Test")
                .header("responseType", "ResponseType.json")
                .header("followRedirects", true)
                .header("connectTimeout", 0)
                .header("receiveTimeout", 0);
    }

    public String getAccessTokenSecond() {
        JSONObject loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL2).password(VALID_PASS2).build().createBody();
        ClientForToken clientForToken = new ClientForToken();

        JSONObject responseToken = clientForToken.postCall(AUTH_SIGNIN, loginRequestDto);
        assertThat(responseToken.getInt("Status Code")).isEqualTo(200);

        return accessToken = responseToken.getString("token");
    }
}
