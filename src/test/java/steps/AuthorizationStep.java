package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import ui.pages.AuthorizationScreen;

public class AuthorizationStep {

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
    public void checkLogInButtonActivity(Boolean activity) {
        Assert.assertEquals(authorizationScreen.getLogInButtonActivity(), activity);
    }

    @Step("Check error message")
    public void verifyErrorMessage(String errorMessage) {
        Assert.assertEquals(authorizationScreen.getErrorMessage(), errorMessage);
    }

    //TODO Создать отдельный класс с софт ассертами и использовать их
}
