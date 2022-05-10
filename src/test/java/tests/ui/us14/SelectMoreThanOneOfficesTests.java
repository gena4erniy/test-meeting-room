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
public class SelectMoreThanOneOfficesTests extends BaseTest {
    private LocationChoose locationchoose;
    private BelarusCitiesChoose belarusCitiesChoose;
    private UkranianCitiesChoose ukranianCitiesChoose;
    private RussianCitiesChoose russianCitiesChoose;
    private CountriesPage countriesPage;


    public SelectMoreThanOneOfficesTests() throws MalformedURLException {
    }

    @BeforeClass
    private void precondition() {
        authorization();
        locationchoose = new LocationChoose();
        belarusCitiesChoose = new BelarusCitiesChoose();
        ukranianCitiesChoose = new UkranianCitiesChoose();
        russianCitiesChoose = new RussianCitiesChoose();
        countriesPage = new CountriesPage();
        driver.findElement(locationchoose.getSelectButton()).click();

    }


    @Owner("Sirozh E.")
    @TmsLink("5633226")
    @Test(description = "User cannot select more then one city for the location of the office\n" +
            "The Select location is dispalyed after tapping on the city")
    public void checkListCountriesIsDisplayed() {
        Assert.assertEquals(driver.findElement(countriesPage.getSelectUkraine()).getText(), "Ukraine");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectRussia()).getText(), "Russia");
        Assert.assertEquals(driver.findElement(countriesPage.getSelectBelarus()).getText(), "Belarus");
        driver.findElement(countriesPage.getSelectBelarus()).click();
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonGomel()).getText(), "Gomel");
        Assert.assertEquals(driver.findElement(belarusCitiesChoose.getButtonMinsk()).getText(), "Minsk");
        if (driver.findElement(belarusCitiesChoose.getButtonMinsk()).isSelected() && driver.findElement(belarusCitiesChoose.getButtonGomel()).isSelected()) {
            Assert.fail("выбраны все варики");
        }
    }

}
