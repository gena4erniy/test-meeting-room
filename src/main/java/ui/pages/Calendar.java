package ui.pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class Calendar {
    private final By choseMonth = By.xpath("//android.widget.TextView[@index = '1'][1]");
    private final By nextButton = By.xpath("//android.widget.ImageButton[@content-desc = 'next']");
    private final By mondayDate = By.xpath("//android.widget.CheckedTextView[1]");
    private final By dateOfDay = By.xpath("//android.widget.CheckedTextView");
    /* private final By previousButton = By.xpath("//android.widget.ImageButton[@content-desc='Go to previous']");*/

//Переменные для всплывающего окна "Календарь"
    private final By buttonOk = By.id("android:id/button1");
    private final By buttonCancel = By.id("android:id/button2");
    private final By buttonNextInCalendar = By.id("android:id/next");
    private final By buttonPrevInCalendar = By.id("android:id/prev");
    private final By buttonYear = By.id("android:id/date_picker_header_year");
    private final By thisYearButton = By.xpath("(//android.widget.TextView[@resource-id = 'android:id/text1'])[1]");
    private final By dateSelectionButton = By.id("android:id/date_picker_header_date");



}
