package tests.ui.login.us12;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.AuthorizationStep;
import steps.LocationStep;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.VALID_MAIL_ADMIN;
import static ui.constants.Constant.ValidCredo.VALID_PASS_ADMIN;

@Epic("Login")
@Feature("US 1.2")
public class AdministratorAuthorizationTests extends BaseUiTest {

    private AuthorizationStep authorizationStep = new AuthorizationStep();
    private LocationStep locationStep = new LocationStep();

    @Owner("Danilenko D.")
    @TmsLink("5629375")
    @Test(description = "Administrator authorization using valid data")
    public void administratorAuthorizationUsingValidData() {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail(VALID_MAIL_ADMIN);
        authorizationStep.checkLogInButtonActivity(false, "Log in button is active");
        authorizationStep.enterPassword(VALID_PASS_ADMIN);
        authorizationStep.checkLogInButtonActivity(true, "Log in button is active");
        authorizationStep.tapOnLogInButton();
        locationStep.onLocationScreen();
        locationStep.verifyTitle("Select your location", "Title does not match");
        authorizationStep.checkAll();
    }
}
