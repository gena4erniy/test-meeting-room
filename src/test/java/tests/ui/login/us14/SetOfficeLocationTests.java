package tests.ui.login.us14;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.*;
import tests.ui.BaseUiTest;

import static ui.constants.Constant.ValidCredo.VALID_MAIL;
import static ui.constants.Constant.ValidCredo.VALID_PASS;

@Epic("Login")
@Feature("US 1.4")
public class SetOfficeLocationTests extends BaseUiTest {

    private AuthorizationStep authorizationStep = new AuthorizationStep();
    private LocationStep locationStep = new LocationStep();
    private CountryStep countryStep = new CountryStep();
    private BelarusCityStep belarusCityStep = new BelarusCityStep();
    private UkraineCityStep ukraineCityStep = new UkraineCityStep();
    private MySpaceStep mySpaceStep = new MySpaceStep();

    @BeforeMethod
    public void beforeMethod() {
        authorizationStep.onAuthorizationScreen();
        authorizationStep.enterEmail(VALID_MAIL);
        authorizationStep.enterPassword(VALID_PASS);
        authorizationStep.tapOnLogInButton();
        locationStep.onLocationScreen();
        locationStep.verifyTitle("Select your location", "Title does not match");
    }

    @Owner("Danilenko D.")
    @TmsLink("5630744")
    @Test(description = "Tap on \"Back\" button on the Location page for countries")
    public void tapOnBackButtonOnTheLocationPageForCountries() {
        locationStep.tapSelectLocationButton();
        countryStep.onCountryScreen();
        countryStep.verifyTitle("Country", "Title \"Country\" does not match");
        countryStep.tapBackButton();
        locationStep.verifyTitle("Select your location", "Title does not match");
        authorizationStep.checkAll();
    }

    @Owner("Danilenko D.")
    @TmsLink("5630745")
    @Test(description = "Tap on \"Country\" button on the Location page for cities")
    public void tapOnCountryButtonOnTheLocationPageForCountries() {
        locationStep.tapSelectLocationButton();
        countryStep.onCountryScreen();
        countryStep.verifyTitle("Country", "Title \"Country\" does not match");
        countryStep.tapBelarusSelectButton();
        belarusCityStep.onCityScreen();
        belarusCityStep.verifyTitle("City", "Title \"City\" does not match");
        belarusCityStep.tapGomelRadioButton();
        locationStep.verifyTitle("Select your location", "Title \"Select your location\" does not match");
        authorizationStep.checkAll();
    }

    @Owner("Danilenko D.")
    @TmsLink("5630751")
    @Test(description = "Select an office location")
    public void selectAnOfficeLocation() {
        locationStep.tapSelectLocationButton();
        countryStep.onCountryScreen();
        countryStep.verifyTitle("Country", "Title \"Country\" does not match");
        countryStep.tapUkraineSelectButton();
        ukraineCityStep.onCityScreen();
        ukraineCityStep.verifyTitle("City", "Title \"City\" does not match");
        ukraineCityStep.tapKievRadioButton();
        locationStep.verifyTitle("Select your location", "Title \"Select your location\" does not match");
        locationStep.tapNextButton();
        mySpaceStep.onMySpaceScreen();
        mySpaceStep.verifyTitle("My space", "Title \"My space\" does not match");
        authorizationStep.checkAll();
    }
}
