import model.Game;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class SteamGameTest  extends BaseTest{

    @Steps
    TestSteps testSteps;
    List<Game> games;
    Game testGame;


    @Test
    public void checkGameData(){
        testSteps.openActionsPage();
        testSteps.openTopSellers();
        testSteps.findSalesGames();
        games = testSteps.getObjectGames();
        //testGame = testSteps.findGameBySale(games);

    }

}
