package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CountriesPage {
    private final By backButton = By.id("arrow_back_location_fragment");
    private final By locationText = By.xpath("//android.widget.TextView[@text = 'Location']");
    private final By selectRussia = By.xpath("//android.widget.TextView[@text = 'Russia']");
    private final By selectUkraine = By.xpath("//android.widget.TextView[@text = 'Ukraine']");
    private final By selectBelarus = By.xpath("//android.widget.TextView[@text = 'Belarus']");
    private final By countryText = By.xpath("//android.widget.TextView[@text = 'Country']");
}