package steps;

import io.qameta.allure.Step;
import ui.screens.ModifyEventScreen;
import verification.VerifySoft;

public class ModifyEventStep extends BaseStep {

    ModifyEventScreen modifyEventScreen = new ModifyEventScreen();

    @Step("On my space screen")
    public void onMySpaceScreen() {
        modifyEventScreen = new ModifyEventScreen();
    }

    @Step("Get title")
    public String getTitle() {
        return modifyEventScreen.getTitle();
    }

    @Step("Tap toolbar save cancel button")
    public void tapToolbarSaveCancelButton() {
        modifyEventScreen.tapToolbarSaveCancelButton();
    }

    @Step("Enter event modify title")
    public void enterEventModifyTitle(String eventTitle) {
        modifyEventScreen.enterEventModifyTitle(eventTitle);
    }

    @Step("Enter event description")
    public void enterEventDescription(String eventDescription) {
        modifyEventScreen.enterEventDescription(eventDescription);
    }

    @Step("Check title")
    public void verifyTitle(String title, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getTitle(), title, message);
    }

    @Step("Check event modify title")
    public void verifyEventModifyTitle(String expectedEventTitle, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getEventModifyTitle(), expectedEventTitle, message);
    }

    @Step("Check event modify title length")
    public void verifyEventModifyTitleLength(int expectedLength, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getEventModifyTitleLength(), expectedLength, message);
    }

    @Step("Check event description")
    public void verifyEventDescription(String expectedEventDescription, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getEventDescription(), expectedEventDescription, message);
    }

    @Step("Check event description length")
    public void verifyEventDescriptionLength(int expectedLength, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getEventDescriptionLength(), expectedLength, message);
    }

    @Step("Check toolbar save cancel button visibility")
    public void checkToolbarSaveCancelButtonVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getToolbarSaveCancelButtonVisibility(), visibility, message);
    }

    @Step("Check modify time icon visibility")
    public void checkModifyTimeIconVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getModifyTimeIconVisibility(), visibility, message);
    }

    @Step("Check Door icon visibility")
    public void checkDoorIconVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getDoorIconVisibility(), visibility, message);
    }

    @Step("Check line under event modify title visibility")
    public void checkLineUnderEventModifyTitleVisibility(Boolean visibility, String message) {
        VerifySoft.verifyEqualsSoft(modifyEventScreen.getLineUnderEventModifyTitleVisibility(), visibility, message);
    }
}
