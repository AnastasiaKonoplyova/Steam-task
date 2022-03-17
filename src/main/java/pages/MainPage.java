package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://store.steampowered.com/")
public class MainPage extends PageObject{

    @FindBy(xpath = "//div[@id='genre_tab']")
    WebElementFacade genreMenu;
    private final String actionLocator = "//div[contains(@data-genre-group,'action') and contains(@class,'popup_menu_subheader')]//a";

    public void openActionPage(){
        genreMenu.find(By.xpath(actionLocator)).click();
    }

    public void openGenreMenu(){
        genreMenu.click();
    }
}
