package pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.TestParam;


public class MenuComponent extends PageComponent {

    private String MENU_LOCATOR = "//div[@class='store_nav_bg']//div[contains(@class,'flyout_tab')]";
    private final String GENRE_LOCATOR = "//div[@data-genre-group]";

    public void openGenrePage(String genre){
        ListOfWebElementFacades genreList = findAll(By.xpath(GENRE_LOCATOR));
        genreList.stream()
                 .filter(webElementFacade -> webElementFacade.isVisible())
                 .filter(webElementFacade -> webElementFacade.getAttribute("data-genre-group")
                         .equals(TestParam.GAME_GENRE.getTitle()))
                 .findFirst().get().find(By.xpath(".//a")).click();
    }

    public void openMenu(String subMenu){
        ListOfWebElementFacades menuList = findAll(By.xpath(MENU_LOCATOR));
        WebElementFacade subMenuEl =  menuList.stream()
                .filter(webElementFacade -> webElementFacade.getAttribute("id").contains(TestParam.SUBMENU.getTitle()))
                .findFirst().get();
        withAction().moveToElement(subMenuEl).build().perform();
    }

}
