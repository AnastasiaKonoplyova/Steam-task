package pages;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://store.steampowered.com/")
public class MainPage extends BasePage{

    public void openGenrePage(String subMenu,String genre){
        openSubMenu(subMenu);
        openGenre(genre);
    }
}
