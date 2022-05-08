package tests.ui.us12;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;


import java.net.MalformedURLException;


@Epic("Login")
@Feature("US 1.2")
public class AdministratorTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;
    private RoomsPage roomsPage;

    public AdministratorTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorizationAdmin();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        roomsPage = new RoomsPage();

    }

    @Owner("Sirozh E.")
    @TmsLink("5639663")
    @Test(description = "Select location page is displayed")
    public void openPageSelectLocation() {
        Assert.assertTrue(driver.findElement(locationchoose.getSelectLoc()).isDisplayed(), "ldldldld");
    }

    @Owner("Sirozh E.")
    @TmsLink("5639663")
    @Test(description = "Office is displayed in the Cascading menu")
    public void checkOfficeDisplayedInMenu() {
        driver.findElement(locationchoose.getSelectButton()).click();
        driver.findElement(countriesPage.getSelectUkraine()).click();
        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
        Assert.assertTrue(driver.findElement(locationchoose.getCityName()).getText().equals("Kiev"), "hhhhhhh");
    }

    @Owner("Sirozh E.")
    @TmsLink("5639663")
    @Test(description = "My space page is displayed")
    public void checkOpenSpacePage() {
        checkOfficeDisplayedInMenu();
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getMySpaceTitle()).getText().equals("My space"));
    }

    @Owner("Sirozh E.")
    @TmsLink("5639663")
    @Test(description = "Administrator can't magane a selected event card")
    public void checkAdminCanNotManageEvent() {
        checkOpenSpacePage();
        driver.findElement(mySpacePage.getRoomsTitle()).click();
        driver.findElement(roomsPage.getNextDate()).click();
        driver.findElement(roomsPage.getChoseDate()).click();
        driver.findElement(roomsPage.getChoseEvent()).click();
        Assert.assertFalse(driver.findElement(roomsPage.getEventCard()).isSelected());
    }




//    @Test
//    public void notManageEventsAdmin() {
//        driver.findElement(locationchoose.getSelectLoc()).click();
//        driver.findElement(countriesPage.getSelectUkraine()).click();
//        driver.findElement(ukranianCitiesChoose.getButtonKiev()).click();
//        driver.findElement(locationchoose.getNextButton()).click();
//        driver.findElement(mySpacePage.getRoomsImage()).click();
//        driver.findElement(mySpacePage.getChooseDataButton()).click();
//        driver.findElement(mySpacePage.getChooseEventButton()).click();
//
//    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}

