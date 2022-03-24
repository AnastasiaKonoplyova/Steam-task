package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class InstallPage extends BasePage {

    @FindBy(xpath = "//div[@id='about_greeting']//a[contains(@class,'install_steam')]")
    WebElementFacade downloadLn;

    public String getDownloadLink(){
        return downloadLn.getAttribute("href");
    }


}
