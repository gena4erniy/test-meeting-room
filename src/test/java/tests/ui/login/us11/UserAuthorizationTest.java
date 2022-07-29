package tests.ui.login.us11;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.AuthorizationStep;
import steps.LocationStep;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

@Epic("Login")
@Feature("US 1.1")
public class UserAuthorizationTest extends BaseUiTest {

    private AuthorizationStep authorizationStep = new AuthorizationStep();
    private LocationStep locationStep = new LocationStep();

    @Owner("Danilenko D.")
    @TmsLink("5628118")
    @Test(description = "User authorization using valid data")
    public void userAuthorizationUsingValidData() {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail(VALID_MAIL);
        authorizationStep.checkLogInButtonActivity(false, "Log in button is active");
        authorizationStep.enterPassword(VALID_PASS);
        authorizationStep.checkLogInButtonActivity(true, "Log in button is active");
        authorizationStep.tapOnLogInButton();
        locationStep.onLocationScreen();
        locationStep.verifyTittle("Select your location", "Tittle does not match");
        authorizationStep.checkAll();
    }

    @DataProvider(name = "Create data for error user authorization using invalid email test")
    public Object[][] createDataForErrorUserAuthorizationUsingInvalidEmailTest() {
        return new Object[][]{
                {"vladimir@andersenlab.c"},
                {"abc@@andersenlab.com"},
                {"abcandersenlab.com"},
                {"@abc@andersenlab.com"},
                {"vladimir@a.com"},
                {".abc@andersenlab.com"},
                {"abc.@andersenlab.com"},
                {"abc.ab.c@andersenlab.com"},
                {"sascha@andersenlab..com"},
                {"ڎ©€£¥µαъъъъщщщщъъ你你你你sss@andersenlab.com"},
                {" dfh@andersenlab.com"},
                {"df   h@gmail.com"},
                {"dfh@andersenlab.com "}
        };
    }

    @Owner("Danilenko D.")
    @TmsLinks({@TmsLink("5628572"), @TmsLink("5638948"), @TmsLink("5628573"), @TmsLink("5638947"), @TmsLink("5628581"),
            @TmsLink("5629123"), @TmsLink("5634585"), @TmsLink("5634583")})
    @Test(dataProvider = "Create data for error user authorization using invalid email test", description = "User authorization using invalid e-mail")
    public void errorUserAuthorizationUsingInvalidEmail(String email) {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail(email);
        authorizationStep.checkLogInButtonActivity(false, "Log in button is active");
        authorizationStep.enterPassword(VALID_PASS);
        authorizationStep.checkLogInButtonActivity(true, "Log in button is active");
        authorizationStep.tapOnLogInButton();
        authorizationStep.verifyErrorMessage("Incorrect e-mail or password!", "Error message does not match");
        authorizationStep.checkAll();
    }
}
