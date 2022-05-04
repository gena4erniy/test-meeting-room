package tests.ui.us12;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

@Epic("Login")
@Feature("US 1.2")
public class AdministratorNotManageTests extends AutorizationAdminTests {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;
    private AndroidDriver<AndroidElement> driver;
    private MySpacePage mySpacePage;

    public AdministratorNotManageTests() throws MalformedURLException {
    }

    //public class AdministratorNotManageTests {
    @BeforeClass
    private void precondition() {
        authorizationAdmin();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getSelectButton()).click();
    }

    @Test
    public void notManageEventsAdmin() {

        driver.findElement(locationchoose.getSelectLoc()).click();
        driver.findElement(countriesPage.getSelectUkraine()).click();
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        driver.findElement(locationchoose.getNextButton()).click();
        driver.findElement(mySpacePage.getRoomsImage()).click();
        driver.findElement(mySpacePage.getChooseDataButton()).click();
        driver.findElement(mySpacePage.getChooseEventButton()).click();

    }
}
