package tests.ui;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import ui.pages.*;
import ui.pages.modifyEvent.ModifyEventPage;

import static ui.constants.Constant.ValidCredo.*;
import static ui.constants.Constant.ValidCredo2.VALID_MAIL2;
import static ui.constants.Constant.ValidCredo2.VALID_PASS2;
import static ui.constants.Constant.ValidNoEventRoomCredo.VALID_MAIL_NO_EVENT_ROOM;
import static ui.constants.Constant.ValidNoEventRoomCredo.VALID_PASS_NO_EVENT_ROOM;
import static ui.pages.BasePage.capabilities;

public class BaseTest {
    private AuthorizationPage authorizationPage = new AuthorizationPage();
    private LocationChoose locationchoose = new LocationChoose();
    private MySpacePage mySpacePage = new MySpacePage();
    private ModifyEventPage modifyEventPage = new ModifyEventPage();
    public AndroidDriver<AndroidElement> driver;
    private ToolBar toolBar = new ToolBar();
    private Calendar calendar = new Calendar();


    public BaseTest() {
    }

    @SneakyThrows
    public void authorization() {
        driver = capabilities();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "Login is not succeed");
    }

    @SneakyThrows
    public void authorizationWithNoEvents() {
        driver = capabilities();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL_NO_EVENT_ROOM);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS_NO_EVENT_ROOM);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "Login is not succeed");
    }

    @SneakyThrows
    public void authorizationAdmin() {
        driver = capabilities();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL_ADMIN);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS_ADMIN);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "Login for admin is not succeed");
    }

    public void setTimeToReminder() {
        driver.findElement(mySpacePage.getEventCard()).click();
        driver.findElement(modifyEventPage.getReminder()).click();
        driver.findElement(modifyEventPage.getReminder5Min()).click();
        driver.findElement(modifyEventPage.getSave()).click();
    }

    @SneakyThrows
    public void authorization2() {
        driver = capabilities();
        driver.findElement(authorizationPage.getEmailInput()).sendKeys(VALID_MAIL2);
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(VALID_PASS2);
        driver.findElement(authorizationPage.getButtonLogin()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "Login is not succeed");
    }



    public void openMySpace(){
        driver.findElement(toolBar.getMySpace()).click();
    }

    public void openRoom(){
        driver.findElement(toolBar.getRooms()).click();
    }
    public void MeetNow(){
        driver.findElement(toolBar.getMeetNow()).click();
    }
    public void workplaces(){
        driver.findElement(toolBar.getWorkPlaces()).click();
    }
    public void Map(){
        driver.findElement(toolBar.getMap()).click();
    }

    public void chooseMonth(String n1){
        while(!driver.findElement(calendar.getChoseMonth()).getText().contains(n1)){
            driver.findElement(calendar.getNextButton()).click();
        }
    }
    public void chooseDay(String n1){
        int count = driver.findElements(calendar.getDateOfDay()).size();
        for (int i = 0; i<count; i++){
            String text2 = driver.findElements(calendar.getDateOfDay()).get(i).getText();
            if(text2.equalsIgnoreCase(n1)){
                driver.findElements(calendar.getDateOfDay()).get(i).click();
            }
        }
    }


    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
