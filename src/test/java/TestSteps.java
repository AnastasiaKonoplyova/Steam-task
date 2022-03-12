import model.Game;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import pages.ActionsGamesPage;
import pages.AgeCheckPage;
import pages.MainPage;
import utils.GameUtil;

import java.util.List;

public class TestSteps {

    MainPage mainPage;
    ActionsGamesPage actionsGamesPage;
    AgeCheckPage ageCheckPage;
    @Managed(uniqueSession=true, driver="chrome")
    WebDriver driver;

    @Step("Starting test, open main page and then actions games page")
    public void openActionsPage(){
        mainPage.open();
        mainPage.openActionPage();
    }

    @Step("Checkout tabs for top sellers")
    public void openTopSellers(){
        actionsGamesPage.openTopSellers();
    }

    @Step("Check if games with sales exist on the page. If false -> turn page")
    public void findSalesInGames(){
        actionsGamesPage.fillGameList();
        while (!actionsGamesPage.ifSalesExit()){
            actionsGamesPage.turnMenu();
            findSalesInGames();
        }
    }

    @Step("Get games as objects")
    public List<Game> getObjectGames(){
       return actionsGamesPage.getGames();
    }

    @Step("Find game with max sale")
    public Game findGameBySale(List<Game> games){
        return GameUtil.findGameWithMaxSale(games);
    }

    @Step("Open page with max Sale")
    public void openGamePageBySale(Game game){
        actionsGamesPage.openGamePage(game);
    }

    @Step("Check is needed page")
    public boolean isAgeCheckPage(){
        return ageCheckPage.isAgeCheckPage(driver.getCurrentUrl());
    }


}
