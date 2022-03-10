package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://store.steampowered.com/")
public class MainPage extends PageObject{

    @FindBy(xpath = "//a[contains(@href,'/category/action/')]")
    private WebElementFacade actionLn;

    public void openActionPage(){
        actionLn.click();
    }
}
