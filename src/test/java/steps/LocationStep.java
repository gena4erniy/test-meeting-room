package steps;

import io.qameta.allure.Step;
import ui.screens.LocationScreen;
import verification.VerifySoft;

public class LocationStep extends BaseStep {

    private LocationScreen locationScreen;

    @Step("On location screen")
    public void onLocationScreen() {
        locationScreen = new LocationScreen();
    }

    @Step("Tap select location button")
    public void tapSelectLocationButton() {
        locationScreen.tapSelectLocationButton();
    }

    @Step("Tap next button")
    public void tapNextButton() {
        locationScreen.tapNextButton();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(locationScreen.getTitle(), title, message);
    }
}
