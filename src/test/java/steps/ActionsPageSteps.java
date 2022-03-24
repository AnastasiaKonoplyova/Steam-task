package steps;

import model.Game;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import pages.ActionsGamesPage;
import parameters.TestParam;
import utils.GameUtil;

import java.util.List;

public class ActionsPageSteps {

    ActionsGamesPage actionsGamesPage;
    List<Game> games;

    @Step("Checkout tabs for top sellers")
    public void openTopSellers(){
        actionsGamesPage.openTopSellers();
    }

    @Step("Find games with sale")
    public boolean fillGamesWithSale(){
        games = actionsGamesPage.getGamesWithSale();
        if(games.isEmpty()){
            actionsGamesPage.showMoreGames();
            return fillGamesWithSale();
        }
        return true;
    }

    @Step("Open game age with max sale")
    public void openGamePage(){
        Game testGame = GameUtil.findGameWithMaxSale(games);
        Serenity.setSessionVariable(TestParam.TEST_GAME.getTitle()).to(testGame);
        actionsGamesPage.openGamePage(testGame);
    }
}
