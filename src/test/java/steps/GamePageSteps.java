package steps;

import model.Game;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.GamePage;
import utils.GameUtil;

public class GamePageSteps {

    GamePage gamePage;
    Game testGame, gameFromPage;

    @Step("Get cost data about game")
    public void getGameDataFromPage(){
        testGame = Serenity.sessionVariableCalled("testGame");
        gameFromPage = GameUtil.convertToGame(testGame.getName(),
                gamePage.getGameSale(), gamePage.getGameFinalPrice(), gamePage.getGameOrigPrice());
        Serenity.setSessionVariable("gameFromPage").to(gameFromPage);
    }

    @Step("Compare games from game list and page")
    public void compareGames(){
        Assert.assertTrue("Games are differ by sale", testGame.getSale()==gameFromPage.getSale());
        Assert.assertTrue("Games are differ by final cost", testGame.getFinalPrice().equals(gameFromPage.getFinalPrice()));
        Assert.assertTrue("Games are differ by orig price", testGame.getOriginPrice().equals(gameFromPage.getOriginPrice()));
        gamePage.openInstallPage();
    }
}
