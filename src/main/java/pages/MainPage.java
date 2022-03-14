package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://store.steampowered.com/")
public class MainPage extends PageObject{

    @FindBy(xpath = "//a[contains(@href,'/Action/')]")
    WebElementFacade actionLn;

    public void openActionPage(){
        actionLn.waitUntilEnabled().click();
    }
}
