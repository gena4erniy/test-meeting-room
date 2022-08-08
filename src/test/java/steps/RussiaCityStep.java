package steps;

import io.qameta.allure.Step;
import ui.screens.RussiaCityScreen;
import verification.VerifySoft;

public class RussiaCityStep extends BaseStep {

    private RussiaCityScreen russiaCityScreen;

    @Step("On city screen")
    public void onCityScreen() {
        russiaCityScreen = new RussiaCityScreen();
    }

    @Step("Tap Saint Petersburg radio button")
    public void tapSaintPetersburgRadioButton() {
        russiaCityScreen.tapSaintPetersburgRadioButton();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(russiaCityScreen.getTitle(), title, message);
    }
}
