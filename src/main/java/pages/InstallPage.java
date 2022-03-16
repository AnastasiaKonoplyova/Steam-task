package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.StringUtil;

public class InstallPage extends PageObject {

    @FindBy(xpath = "(//a[contains(@class,'install_steam')])[1]")
    WebElementFacade installLn;

    public void downloadInstaller(){
        installLn.click();
    }

    public String getFileName(){
        return StringUtil.getFileNameFromLink(installLn.getAttribute("href"));
    }

}
