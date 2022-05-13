package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class ToolBar {
    private final By mySpace = By.xpath("//android.widget.TextView[@text = 'My Space']");
    private final By rooms = By.xpath("//android.widget.TextView[@text = 'Rooms']");
    private final By meetNow = By.xpath("//android.widget.TextView[@text = 'Meet now']");
    private final By workPlaces = By.xpath("//android.widget.TextView[@text = 'Workplaces']");
    private final By map =  By.xpath("//android.widget.TextView[@text = 'Map']");

}
