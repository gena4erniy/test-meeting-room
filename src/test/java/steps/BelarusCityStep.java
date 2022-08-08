package steps;

import io.qameta.allure.Step;
import ui.screens.BelarusCityScreen;
import verification.VerifySoft;

public class BelarusCityStep extends BaseStep {

    private BelarusCityScreen belarusCityScreen;

    @Step("On city screen")
    public void onCityScreen() {
        belarusCityScreen = new BelarusCityScreen();
    }

    @Step("Tap Minsk radio button")
    public void tapMinskRadioButton() {
        belarusCityScreen.tapMinskRadioButton();
    }

    @Step("Tap Gomel radio button")
    public void tapGomelRadioButton() {
        belarusCityScreen.tapGomelRadioButton();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(belarusCityScreen.getTitle(), title, message);
    }
}
