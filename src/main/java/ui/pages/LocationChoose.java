package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class LocationChoose {
    private final By logoImg = By.xpath("//android.widget.ImageView");
    private final By selectLoc = By.xpath("//android.widget.TextView[@text = 'Select your location']");
    private final By selectButton = By.xpath("//android.widget.ImageButton");
    private final By cityName = By.xpath("//android.widget.TextView[2]");
    private final By nextButton = By.xpath("//android.widget.TextView[@text = 'NEXT']");
    private final By backButton = By.id("arrow_back_location_fragment");
}