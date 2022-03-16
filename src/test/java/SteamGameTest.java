import model.Game;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.JSONReader;

import java.util.List;

@RunWith(SerenityRunner.class)
public class SteamGameTest  extends BaseTest{

    @Steps
    TestSteps testSteps;
    List<Game> games;
    Game testGame, gameFromPage;


    @Test
    public void checkGameData(){
        testSteps.openActionsPage();
        testSteps.openTopSellers();
        testSteps.findSalesGames();
        games = testSteps.getObjectGames();
        testGame = testSteps.findGameBySale(games);
        testSteps.openGamePageBySale(testGame);
        if (testSteps.isAgeCheckPage(driver.getCurrentUrl())){
            if(testSteps.isSelectDateBlockDisplayed()){
                testSteps.inputValidDate(Long.parseLong(JSONReader.getTestDataJSON("ageRange")));
            }
            testSteps.openGamePageFromAgeCheck();
        }
        gameFromPage = testSteps.getGameData(testGame.getName());
        Assert.assertTrue("Games are different", gameFromPage.equals(testGame));
        testSteps.downloadInstaller();
        String path = System.getProperty("user.home")+"/Downloads/";
        Assert.assertTrue("Installer wasn't downloaded", testSteps.isFileDownload(path));
    }

}
