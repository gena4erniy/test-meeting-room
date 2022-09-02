package tests.api.auth.controller;

import api.core.ClientForToken;
import api.dto.LoginRequestDto;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.core.ApiEndpoints.AUTH_REFRESH;
import static api.core.ApiEndpoints.AUTH_SIGNIN;
import static org.assertj.core.api.Assertions.assertThat;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class GetANewPairOfTokensUsingRefreshTokenTests {
    private ClientForToken clientForToken;
    private JSONObject loginRequestDto;
    private String token;

    @BeforeClass
    private void precondition() {
        loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL).password(VALID_PASS).build().createBody();
        clientForToken = new ClientForToken();
        JSONObject responseTokens = clientForToken.postCall(AUTH_SIGNIN, loginRequestDto);
        token = responseTokens.getString("token");
    }

    @Owner(value = "Golcova A.")
    @Test(description = "Checking the receipt of a new pair of tokens.")
    @Description("Checking the receipt of a new pair of tokens.")
    public void tokensUpdate() {

        JSONObject responseRefreshTokens = clientForToken.postCallHeader(AUTH_REFRESH, token);
        assertThat(responseRefreshTokens.getInt("Status Code")).isEqualTo(200);
        assertThat(responseRefreshTokens.get("token")).isNotNull();
        assertThat(responseRefreshTokens.get("refreshToken")).isNotNull();
    }
}
