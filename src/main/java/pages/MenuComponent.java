package pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;
import parameters.GenreMenuParam;
import parameters.MainMenuParam;

import java.util.Optional;


public class MenuComponent extends PageComponent {

    private String MENU_LOCATOR = "//div[@class='store_nav_bg']//div[contains(@class,'flyout_tab')]";
    private final String GENRE_LOCATOR = "//div[@data-genre-group]";

    public WebElementFacade openGenrePage(GenreMenuParam genre){
        ListOfWebElementFacades genreList = findAll(By.xpath(GENRE_LOCATOR));
        Optional<WebElementFacade> genreLink = genreList.stream()
                 .filter(WebElementState::isVisible)
                 .filter(webElementFacade -> webElementFacade.getAttribute("data-genre-group")
                         .equals(genre.getTitle()))
                 .findFirst();
        return genreLink.orElse(null);
    }

    public WebElementFacade openMenu(MainMenuParam subMenu){
        ListOfWebElementFacades menuList = findAll(By.xpath(MENU_LOCATOR));
        Optional <WebElementFacade> subMenuEl =  menuList.stream()
                .filter(webElementFacade -> webElementFacade.getAttribute("id").contains(subMenu.getTitle()))
                .findFirst();
        return subMenuEl.orElse(null);
    }

}
