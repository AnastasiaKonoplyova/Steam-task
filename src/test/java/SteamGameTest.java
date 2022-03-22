import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import utils.FileUtil;


@RunWith(SerenityRunner.class)
public class SteamGameTest {

    @Steps
    MainPageSteps mainPageSteps;
    @Steps
    ActionsPageSteps actionsPageSteps;
    @Steps
    ValidateSteps validateSteps;
    @Steps
    GamePageSteps gamePageSteps;
    @Steps
    DownloadSteamSteps downloadSteamSteps;

    @Before
    public void startTest(){
        mainPageSteps.openActionsPage();
    }

    @Test
    public void checkGameData(){
        actionsPageSteps.openTopSellers();
        actionsPageSteps.fillGames();
        actionsPageSteps.findGameBySale();
        actionsPageSteps.openGamePage();
        validateSteps.isAgeCheckPage();
        gamePageSteps.getGameDataFromPage();
        gamePageSteps.compareGames();
        downloadSteamSteps.downloadInstaller();
        downloadSteamSteps.isFileDownload();
    }

    @After
    public void endTest(){
        downloadSteamSteps.deleteFile();
    }
}
