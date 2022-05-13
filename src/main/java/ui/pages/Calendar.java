package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;
@Getter
public class Calendar {
    private final By choseMonth = By.xpath("//android.widget.TextView[@index = '1'][1]");
    private final By nextButton = By.xpath("//android.widget.ImageButton[@content-desc = 'next']");
    private final By mondayDate = By.xpath("//android.widget.CheckedTextView[1]");
    private final By dateOfDay = By.xpath("//android.widget.CheckedTextView");

}
