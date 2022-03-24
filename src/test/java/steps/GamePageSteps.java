package steps;

import model.Game;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pages.GamePage;
import parameters.GameParameters;
import parameters.TestParam;
import utils.GameUtil;

public class GamePageSteps {

    GamePage gamePage;

    private Game getGameDataFromPage(Game refGame){
        return GameUtil.convertToGame(refGame.getName(),
                gamePage.getGameValue(GameParameters.SALE), gamePage.getGameValue(GameParameters.FINAL_PRICE),
                gamePage.getGameValue(GameParameters.ORIG_PRICE));
    }

    @Step("Compare games from game list and page")
    public void compareGames(){
        Game testGame = Serenity.sessionVariableCalled(TestParam.TEST_GAME.getTitle());
        Game gameFromPage = getGameDataFromPage(testGame);
        Assert.assertEquals("Games are differ by sale", testGame.getSale(),gameFromPage.getSale());
        Assert.assertEquals("Games are differ by final cost", testGame.getFinalPrice(),gameFromPage.getFinalPrice());
        Assert.assertEquals("Games are differ by orig price", testGame.getOriginPrice(),gameFromPage.getOriginPrice());
    }
}
