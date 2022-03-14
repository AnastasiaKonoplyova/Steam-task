package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.StringUtil;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class InstallPage extends PageObject {

    private WebElementFacade installLn = find(By.xpath("//a[contains(@class,'install_steam')][1]"));

    public void downloadInstaller(){
        installLn.click();
    }

    public String getFileName(){
        return StringUtil.getFileNameFromLink(installLn.getAttribute("href"));
    }

}
