package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject {

    MenuComponent mainMenu;
    @FindBy(xpath = "//a[contains(@class,'installsteam')]")
    WebElementFacade installLn;

    public void openInstallPage(){
        installLn.click();
    }

    public void openSubMenu(String subMenu){
        mainMenu.openMenu(subMenu);
    }

    public void openGenre(String genre){
        mainMenu.openGenrePage(genre);
    }
}
