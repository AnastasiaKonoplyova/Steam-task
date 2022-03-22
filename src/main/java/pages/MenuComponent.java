package pages;

import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;


public class MenuComponent extends PageComponent {

    private String MENU_LOCATOR = "//div[@class='store_nav_bg']//div[@id='%s_tab']";
    private final String GENRE_LOCATOR = "//div[contains(@data-genre-group,'%s') and contains(@class,'popup_menu_subheader')]//a";

    public void openGenrePage(String genre){
        find(By.xpath(String.format(GENRE_LOCATOR, genre))).waitUntilVisible().click();
    }

    public void openMenu(String subMenu){
       withAction().moveToElement(find(By.xpath(String.format(MENU_LOCATOR, subMenu)))).build().perform();
    }

}
