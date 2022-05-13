package tests.ui.us31;

import io.appium.java_client.android.*;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.time.Duration;

@Epic("Login")
@Feature("US 3.1")
public class ScrollUpDown extends BaseTest {
    private LocationChoose locationchoose;
    private TimeElementShedule timeElementShedule;
    private AndroidTouchAction touch;
    private LongPressOptions longpress;


    public ScrollUpDown() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        driver.findElement(locationchoose.getNextButton()).click();
        touch = new AndroidTouchAction(driver);
        longpress = new LongPressOptions();
        timeElementShedule = new TimeElementShedule();
        openRoom();
    }

    @DataProvider(name = "dataScrollDown")
    public Object[][] scrollTestDown() {
        return new Object[][]{
                {timeElementShedule.getTen(),
                        timeElementShedule.getSix()
                },
                {timeElementShedule.getFourteen(), timeElementShedule.getTen()
                },
                {timeElementShedule.getEighteen(), timeElementShedule.getFourteen()
                },
                {timeElementShedule.getTwenty_two(), timeElementShedule.getEighteen()},
        };
    }

    @Owner("Kudayeu S.")
    @TmsLink("5714769")
    @Test(description = "Checking the scrolling of the event grid", dataProvider = "dataScrollDown", priority = 1)
    public void scrollDowm(By xpath1, By xpath2) {
        WebElement one = driver.findElement(xpath1);
        WebElement two = driver.findElement(xpath2);
        Point location1 = two.getLocation();
        longpress.withDuration(Duration.ofSeconds(1)).withElement(ElementOption.element(one));
        touch.longPress(longpress).moveTo(PointOption.point(location1)).release().perform();
    }
    @Owner("Kudayeu S.")
    @TmsLink("5714769")
    @Test(description = "Checking the scrolling of the event grid", priority = 2)
    public void checkZero(){
        Assert.assertTrue(driver.findElement(timeElementShedule.getZero()).isDisplayed(), "Scroll was not success" );
    }

    @DataProvider(name = "dataScrollUp")
    public Object[][] scrollTestUp() {
        return new Object[][]{
                {timeElementShedule.getTwenty_two(),
                        timeElementShedule.getZero()
                },
                {timeElementShedule.getEighteen(), timeElementShedule.getTwenty_two()
                },
                {timeElementShedule.getFourteen(), timeElementShedule.getEighteen()
                },
                {timeElementShedule.getTen(), timeElementShedule.getFourteen()},
                {timeElementShedule.getSeven(), timeElementShedule.getTen()},
        };
    }

    @Owner("Kudayeu S.")
    @TmsLink("5714769")
    @Test(description = "Checking the scrolling of the event grid", dataProvider = "dataScrollUp", priority = 3)
    public void scrollUp(By xpath1, By xpath2) {
        WebElement one = driver.findElement(xpath1);
        WebElement two = driver.findElement(xpath2);
        Point location1 = two.getLocation();
        longpress.withDuration(Duration.ofSeconds(1)).withElement(ElementOption.element(one));
        touch.longPress(longpress).moveTo(PointOption.point(location1)).release().perform();
    }
    @Owner("Kudayeu S.")
    @TmsLink("5714769")
    @Test(description = "Checking the scrolling of the event grid", priority = 4)
    public void checkSix(){
        Assert.assertTrue(driver.findElement(timeElementShedule.getSix()).isDisplayed(), "Scroll was not success" );
    }
}
