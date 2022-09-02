package tests.api.auth.controller;

import api.core.ClientForToken;
import api.dto.LoginRequestDto;
import io.qameta.allure.Owner;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import verification.VerifySoft;

import static api.core.ApiEndpoints.AUTH_SIGNIN;
import static ui.constants.Codes.ERROR_BAD_REQUEST;
import static ui.constants.Codes.ERROR_METHOD_NOT_ALLOWED;
import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

public class AuthenticationAndAuthorizationNegativeTests {

    private ClientForToken clientForToken;
    private JSONObject loginRequestDto;

    @DataProvider(name = "Creating data with invalid emails")
    public Object[][] creatingDataInvalidEmails() {
        return new Object[][]{
                {"user1gmail.com", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"user@1@gmail.com", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"@user1gmail.com", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"user1gmail.com@", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {".user1@gmail.com", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"user1@gmailcom.", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {null, VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {" ", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {" user1@gmail.com", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"user1@gmail.com ", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"user1 @gmail.com", VALID_PASS, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {"user1user1user1user1user1user1user1user1user1user1user1user1user1@gmail.com", VALID_PASS,
                        ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
        };
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting tokens with invalid email", dataProvider = "Creating data with invalid emails")
    public void errorGettingTokensWithInvalidEmail(String email, String password, String expectedStatusCode, String expectedError) {
        authenticationAndAuthorizationNegative(email, password, expectedStatusCode, expectedError);
    }

    @DataProvider(name = "Creating data with invalid pass")
    public Object[][] createDataInvalidPass() {
        return new Object[][]{
                {VALID_MAIL, null, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {VALID_MAIL, "", ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
                {VALID_MAIL, " ", ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription()},
        };
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting tokens with invalid email", dataProvider = "Creating data with invalid pass")
    public void errorGettingTokensWithInvalidPass(String email, String password, String expectedStatusCode, String expectedError) {
        authenticationAndAuthorizationNegative(email, password, expectedStatusCode, expectedError);
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting tokens with empty body")
    public void errorGettingTokensWithEmptyBody() {
        loginRequestDto = LoginRequestDto.builder().build().createBody();
        clientForToken = new ClientForToken();
        JSONObject responseTokens = clientForToken.postCall(AUTH_SIGNIN, loginRequestDto);
        authenticationAndAuthorizationNegative(responseTokens, ERROR_BAD_REQUEST.getCode(), ERROR_BAD_REQUEST.getDescription());
    }

    @Owner("Danilenko D.")
    @Test(description = "Error getting tokens with put call")
    public void errorGettingTokensWithPutCall() {
        loginRequestDto = LoginRequestDto.builder().email(VALID_MAIL).password(VALID_PASS).build().createBody();
        clientForToken = new ClientForToken();
        JSONObject responseTokens = clientForToken.putCall(AUTH_SIGNIN, loginRequestDto);
        authenticationAndAuthorizationNegative(responseTokens, ERROR_METHOD_NOT_ALLOWED.getCode(),
                ERROR_METHOD_NOT_ALLOWED.getDescription());
    }

    public void authenticationAndAuthorizationNegative(String email, String pass, String expectedStatusCode, String expectedError) {
        loginRequestDto = LoginRequestDto.builder().email(email).password(pass).build().createBody();
        clientForToken = new ClientForToken();
        JSONObject responseTokens = clientForToken.postCall(AUTH_SIGNIN, loginRequestDto);
        authenticationAndAuthorizationNegative(responseTokens, expectedStatusCode, expectedError);
    }

    public void authenticationAndAuthorizationNegative(JSONObject responseTokens, String expectedStatusCode, String expectedError) {
        VerifySoft.verifyEqualsSoft(responseTokens.get("Status Code").toString(), expectedStatusCode,
                "Expected status code does not match");
        VerifySoft.verifyEqualsSoft(responseTokens.get("error").toString(), expectedError, "Expected error does not match");
        VerifySoft.verifyEqualsSoft(responseTokens.has("token"), false, "Response body has token");
        VerifySoft.verifyEqualsSoft(responseTokens.has("refreshToken"), false, "Response body has refreshToken");
        VerifySoft.showAllChecking();
    }
}