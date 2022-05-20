package tests.ui.us11;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.AuthorizationPage;
import ui.pages.LocationChoose;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static ui.pages.BasePage.capabilities;

@Epic("Login")
@Feature("US 1.1")
public class DisplayingLogInScreenTests {


    private AndroidDriver<AndroidElement> driver;
    private AuthorizationPage authorizationPage;


    @BeforeClass
    private void preconditions() throws MalformedURLException {
        driver = capabilities();
        authorizationPage = new AuthorizationPage();

    }

    @Owner("Sirozh E.")
    @TmsLink("5628566")
    @Test
    public void checkLoginScreenFieldsTest() {
        Assert.assertTrue(driver.findElement(authorizationPage.getLogoImg()).isDisplayed(),"Element Andersen Label isn't displayed");
        Assert.assertTrue( driver.findElement(authorizationPage.getTextOffice()).isDisplayed(),"Element Office Assistant isn't displayed");
        Assert.assertTrue(driver.findElement(authorizationPage.getTextMundle()).isDisplayed(),"Element Subtitle Mundle isn't displayed");
        Assert.assertTrue( driver.findElement(authorizationPage.getEmailInput()).isDisplayed(),"Element E-mail isn't displayed");
        Assert.assertTrue( driver.findElement(authorizationPage.getPasswordInput()).isDisplayed(),"Element Password isn't displayed");
        Assert.assertTrue(driver.findElement(authorizationPage.getEyeIcon()).isDisplayed(),"Element Eye isn't displayed");
        Assert.assertTrue( driver.findElement(authorizationPage.getButtonLogin()).isDisplayed(),"Element Login isn't displayed");
        Assert.assertTrue(driver.findElement(authorizationPage.getEmailInput()).getText().equals("E-mail"),"Text \"E-mail\" isn't displayed");
        Assert.assertTrue(driver.findElement(authorizationPage.getPasswordInput()).getText().equals("Password"),"Text \"Password\" isn't displayed");
        String pass = "test";
        driver.findElement(authorizationPage.getPasswordInput()).sendKeys(pass);
        Assert.assertTrue(driver.findElement(authorizationPage.getEyeIcon()).isEnabled(),"Element Eye isn't active");
        String elem = driver.findElement(By.xpath("//android.view.ViewGroup[2]")).getText();
        Assert.assertFalse(elem.equals(pass),"Password is displayed");
        Assert.assertFalse(driver.findElement(authorizationPage.getButtonLogin()).isEnabled(),"Element Login isn't active");
    }

}
