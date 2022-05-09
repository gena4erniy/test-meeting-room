package tests.ui.us14;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import ui.pages.*;

import java.net.MalformedURLException;

@Epic("Login")
@Feature("US 1.4")
public class TapNextChooseCorrectOfficeTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;
    private MySpacePage mySpacePage;


    public TapNextChooseCorrectOfficeTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        mySpacePage = new MySpacePage();
        driver.findElement(locationchoose.getSelectButton()).click();

    }

    @Owner("Sirozh E.")
    @TmsLink("5630209")
    @Test(description = "The List of countries page is displayed")
    public void checkListOfCountries() {
        Assert.assertEquals(driver.findElement(countriesPage.getSelectUkraine()).getText(), "Ukraine");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectRussia()).getText(), "Russia");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectBelarus()).getText(), "Belarus");

    }

    @Owner("Sirozh E.")
    @TmsLink("5630209")
    @Test(description = "The List of cities page for Belarus is displayed")
    public void checkListOfBelarus() {
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonGomel()).getText(), "Gomel");
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonMinsk()).getText(), "Minsk");
    }

    @Owner("Sirozh E.")
    @TmsLink("5630209")
    @Test(description = "Tap on the Gomel item")
    public void checkWorkCity() {
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertTrue(driver.findElement(belarusCitiesChoose.getButtonMinsk()).isEnabled());
        //Экран выбора местоположения откроется через 0,3 мс
        driver.findElement(belarusCitiesChoose.getButtonGomel()).click();
        Assert.assertEquals(driver.findElement(locationchoose.getCityName()).getText(), "Gomel");
        Assert.assertTrue(driver.findElement(locationchoose.getNextButton()).isEnabled());
    }

    @Owner("Sirozh E.")
    @TmsLink("5630209")
    @Test(description = "The location choice is saved on the User's device , My space page is displayed.")
    public void checkWorkNextButton() {
        checkWorkCity();
        driver.findElement(locationchoose.getNextButton()).click();
        Assert.assertTrue(driver.findElement(mySpacePage.getMySpaceTitle()).isDisplayed());
        //Выбор местоположения сохраняется на устройстве пользователя.

    }
}
