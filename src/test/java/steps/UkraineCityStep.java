package steps;

import io.qameta.allure.Step;
import ui.screens.UkraineCityScreen;
import verification.VerifySoft;

public class UkraineCityStep extends BaseStep {

    private UkraineCityScreen ukraineCityScreen;

    @Step("On city screen")
    public void onCityScreen() {
        ukraineCityScreen = new UkraineCityScreen();
    }

    @Step("Tap Kiev radio button")
    public void tapKievRadioButton() {
        ukraineCityScreen.tapKievRadioButton();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(ukraineCityScreen.getTitle(), title, message);
    }
}
