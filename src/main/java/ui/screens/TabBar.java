package ui.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabBar extends BaseScreen {

    @FindBy(id = "bottom_nav_view")
    private WebElement tabBar;

    @FindBy(id = "my_space_screen_navigation")
    private WebElement mySpase;

    @FindBy(id = "rooms_screen_navigation")
    private WebElement rooms;

    @FindBy(id = "meet_now_screen_navigation")
    private WebElement meetNow;

    @FindBy(id = "workplaces_screen_navigation")
    private WebElement workplaces;

    @FindBy(id = "map_screen_navigation")
    private WebElement map;

    public void mySpaseClick() {
        mySpase.click();
    }

    public void roomsClick() {
        rooms.click();
    }

    public void meetNowClick() {
        meetNow.click();
    }

    public void workplacesClick() {
        workplaces.click();
    }

    public void mapClick() {
        map.click();
    }
}
