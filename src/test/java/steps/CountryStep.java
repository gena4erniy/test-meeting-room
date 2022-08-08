package steps;

import io.qameta.allure.Step;
import ui.screens.CountryScreen;
import verification.VerifySoft;

public class CountryStep extends BaseStep {

    private CountryScreen countryScreen;

    @Step("On country screen")
    public void onCountryScreen() {
        countryScreen = new CountryScreen();
    }

    @Step("Tap back button")
    public void tapBackButton() {
        countryScreen.tapBackButton();
    }

    @Step("Tap Ukraine select button")
    public void tapUkraineSelectButton() {
        countryScreen.tapUkraineSelectButton();
    }

    @Step("Tap Russia select button")
    public void tapRussiaSelectButton() {
        countryScreen.tapRussiaSelectButton();
    }

    @Step("Tap Belarus select button")
    public void tapBelarusSelectButton() {
        countryScreen.tapBelarusSelectButton();
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(countryScreen.getTitle(), title, message);
    }
}
