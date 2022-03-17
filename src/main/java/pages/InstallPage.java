package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.FileUtil;
import utils.JSONReader;
import utils.StringUtil;

public class InstallPage extends PageObject {

    @FindBy(xpath = "(//a[contains(@class,'install_steam')])[1]")
    WebElementFacade installLn;

    public void downloadSteam(){
        String downloadLink = installLn.getAttribute("href");
        String filePath = String.format(JSONReader.getTestDataJSON("pathToInstaller"), StringUtil.getFileNameFromLink(downloadLink));
        FileUtil.saveFile(downloadLink, filePath);
    }

    public boolean checkDownloadFile(){
        return FileUtil.checkFileExists();
    }
}
