package steps;

import model.Game;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.ActionsGamesPage;
import utils.GameUtil;

import java.util.List;

public class ActionsPageSteps {

    ActionsGamesPage actionsGamesPage;
    List<Game> games;
    Game testGame;

    @Step("Checkout tabs for top sellers")
    public void openTopSellers(){
        actionsGamesPage.openTopSellers();
    }

    public boolean fillGames(){
        games = actionsGamesPage.getGames();
        if(games.isEmpty()){
            actionsGamesPage.showMoreGames();
            return fillGames();
        }
        return true;
    }

    public void findGameBySale(){
        testGame = GameUtil.findGameWithMaxSale(games);
    }

    public void openGamePage(){
        Serenity.setSessionVariable("testGame").to(testGame);
        actionsGamesPage.openGamePage(testGame);
    }
}
