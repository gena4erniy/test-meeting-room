package tests.api;

import api.core.ClientForToken;
import api.dto.LoginRequestDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.core.ApiEndpoints.AUTH_SIGNIN;
import static org.assertj.core.api.Assertions.assertThat;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class GetTokensTests {
    private ClientForToken clientForToken;
    private JSONObject loginRequestDto;

    @BeforeClass
    private void precondition() {
        loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL).password(VALID_PASS).build().createBody();
        clientForToken = new ClientForToken();
    }

    @Owner(value = "Kurchenko V.")
    @Test(description = "Getting a tokens")
    @Description("Getting a tokens")
    public void getTokens() {
        JSONObject responseTokens = clientForToken.postCall(AUTH_SIGNIN, loginRequestDto);
        assertThat(responseTokens.getInt("Status Code")).isEqualTo(200);
        assertThat(responseTokens.get("token")).isNotNull();
        assertThat(responseTokens.get("refreshToken")).isNotNull();
    }
}
