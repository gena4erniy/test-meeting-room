package steps;

import io.qameta.allure.Step;
import ui.pages.LocationScreen;
import verification.VerifySoft;

public class LocationStep extends BaseStep {

    private LocationScreen locationScreen;

    @Step("On authorization screen")
    public void onLocationScreen() {
        locationScreen = new LocationScreen();
    }

    @Step("Check tittle")
    public void verifyTittle(String tittle, String message) {
        VerifySoft.verifyEqualsSoft(locationScreen.getTittle(), tittle, message);
    }
}
