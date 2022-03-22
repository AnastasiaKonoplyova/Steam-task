package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.*;
import utils.*;

public class DownloadSteamSteps {


    InstallPage installPage;

    @Step("Download steam installer")
    public void downloadInstaller(){
        String link = installPage.getDownloadLink();
        String filePath = String.format(TestParam.PATH_TO_INSTALLER.getTitle(),
                StringUtil.getFileNameFromLink(link));
        FileUtil.saveFile(link, filePath);
        Serenity.setSessionVariable("file").to(filePath);
    }

    @Step("Check if installer download")
    public void isFileDownload(){
        Assert.assertTrue("Check if steam installer downloaded",
                FileUtil.isFileDownloaded(Serenity.sessionVariableCalled("file")));
    }

    @Step("Delete file")
    public void deleteFile(){
        FileUtil.deleteFile(Serenity.sessionVariableCalled("file"));
    }
}
