package tests.ui.us11;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.AuthorizationStep;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.VALID_PASS;

@Epic("Login")
@Feature("US 1.1")
public class UserAuthorizationWithInvalidEmailTest extends BaseUiTest {

    private AuthorizationStep authorizationStep = new AuthorizationStep();

    @Owner("Danilenko D.")
    @TmsLink("5638947")
    @Test(description = "User authorization using invalid e-mail containing 1 character after \".\"")
    public void test() {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail("vladimir@andersenlab.c");
        authorizationStep.checkLogInButtonActivity(false);
        authorizationStep.enterPassword(VALID_PASS);
        authorizationStep.checkLogInButtonActivity(true);
        authorizationStep.tapOnLogInButton();
        authorizationStep.verifyErrorMessage("Incorrect e-mail or password!");
    }
}
