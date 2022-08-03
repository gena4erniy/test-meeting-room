package ui.screens;

import driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseScreen {

    public BaseScreen() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
