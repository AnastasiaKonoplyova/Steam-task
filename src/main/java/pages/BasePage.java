package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import parameters.GenreMenuParam;
import parameters.MainMenuParam;

public class BasePage extends PageObject {

    MenuComponent mainMenu;
    @FindBy(xpath = "//a[contains(@class,'installsteam')]")
    WebElementFacade installLn;

    public void openInstallPage(){
        installLn.click();
    }

    private void openSubMenu(MainMenuParam subMenu){
        try {
            withAction().moveToElement(mainMenu.openMenu(subMenu)).build().perform();
        } catch (NullPointerException e)
        {
            e.printStackTrace();
        }

    }

    private void openGenre(GenreMenuParam genre){
        try{
            mainMenu.openGenrePage(genre).find(By.xpath(".//a")).click();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    public void openGenrePage(MainMenuParam subMenu, GenreMenuParam genre){
        openSubMenu(subMenu);
        openGenre(genre);
    }
}
