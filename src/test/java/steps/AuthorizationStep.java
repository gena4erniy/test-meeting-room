package steps;

import io.qameta.allure.Step;
import ui.pages.AuthorizationScreen;
import verification.VerifySoft;

public class AuthorizationStep extends BaseStep{

    private AuthorizationScreen authorizationScreen;

    @Step("On authorization screen")
    public void onAuthorizationScreen() {
        authorizationScreen = new AuthorizationScreen();
    }

    @Step("Enter email to email field")
    public void enterEmail(String email) {
        authorizationScreen.enterEmail(email);
    }

    @Step("Enter password to password field")
    public void enterPassword(String password) {
        authorizationScreen.enterPassword(password);
    }

    @Step("Tap LOG IN button")
    public void tapOnLogInButton() {
        authorizationScreen.tapOnLogInButton();
    }

    @Step("Check LOG IN button activity")
    public void checkLogInButtonActivity(Boolean activity, String message) {
        VerifySoft.verifyEqualsSoft(authorizationScreen.getLogInButtonActivity(), activity, message);
    }

    @Step("Check error message")
    public void verifyErrorMessage(String errorMessage, String message) {
        VerifySoft.verifyEqualsSoft(authorizationScreen.getErrorMessage(), errorMessage, message);
    }
}
