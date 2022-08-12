package tests.ui.login.us13;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.*;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.*;

@Epic("Login")
@Feature("US 1.3")
public class ReturningTests extends BaseUiTest {

    private AuthorizationStep authorizationStep = new AuthorizationStep();
    private LocationStep locationStep = new LocationStep();
    private CountryStep countryStep = new CountryStep();
    private BelarusCityStep belarusCityStep = new BelarusCityStep();
    private MySpaceStep mySpaceStep = new MySpaceStep();
    private SettingsMenuStep settingsMenuStep = new SettingsMenuStep();

    @DataProvider(name = "Create data for returning in the system test")
    public Object[][] createDataForReturningInTheSystemTest() {
        return new Object[][]{
                {VALID_MAIL, VALID_PASS},
                {VALID_MAIL_ADMIN, VALID_PASS_ADMIN}
        };
    }

    @Owner("Danilenko D.")
    @TmsLinks({@TmsLink("5629383"), @TmsLink("5629403")})
    @Test(dataProvider = "Create data for returning in the system test", description = "Returning in the system")
    public void returningInTheSystem(String email, String password) {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.verifyTitle("Office Assistant", "Title \"Office Assistant\" does not match");
        authorizationStep.enterEmail(email);
        authorizationStep.enterPassword(password);
        authorizationStep.checkLogInButtonActivity(true, "Log in button is active");
        authorizationStep.tapOnLogInButton();
        locationStep.onLocationScreen();
        locationStep.verifyTitle("Select your location", "Title \"Select your location\" does not match");
        locationStep.tapSelectLocationButton();
        countryStep.onCountryScreen();
        countryStep.verifyTitle("Country", "Title \"Country\" does not match");
        countryStep.tapBelarusSelectButton();
        belarusCityStep.onCityScreen();
        belarusCityStep.verifyTitle("City", "Title \"City\" does not match");
        belarusCityStep.tapGomelRadioButton();
        locationStep.verifyTitle("Select your location", "Title \"Select your location\" does not match");
        locationStep.tapNextButton();
        mySpaceStep.onMySpaceScreen();
        mySpaceStep.verifyTitle("My space", "Title \"My space\" does not match");
        mySpaceStep.closeApp(driver);
        mySpaceStep.launchApp(driver);
        mySpaceStep.verifyTitle("My space", "Title \"My space\" does not match");
        authorizationStep.checkAll();
    }

    @Owner("Danilenko D.")
    @TmsLink("5629405")
    @Test(description = "Returning in the system after log out")
    public void returningInTheSystemAfterLogOut() {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail(VALID_MAIL);
        authorizationStep.enterPassword(VALID_PASS);
        authorizationStep.tapOnLogInButton();
        locationStep.onLocationScreen();
        locationStep.tapNextButton();
        mySpaceStep.onMySpaceScreen();
        mySpaceStep.verifyTitle("My space", "Title \"My space\" does not match");
        mySpaceStep.tapSettingsButton();
        settingsMenuStep.onSettingsMenuScreen();
        settingsMenuStep.tapLogOutButton();
        authorizationStep.verifyTitle("Office Assistant", "Title \"Office Assistant\" does not match");
        mySpaceStep.closeApp(driver);
        mySpaceStep.launchApp(driver);
        authorizationStep.verifyTitle("Office Assistant", "Title \"Office Assistant\" does not match");
        authorizationStep.checkAll();
    }
}
