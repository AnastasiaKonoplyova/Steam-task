import model.Game;
import net.thucydides.core.annotations.Step;
import pages.*;
import utils.DateUtil;
import utils.FileUtil;
import utils.GameUtil;

import java.time.LocalDate;
import java.util.List;

public class TestSteps{

    MainPage mainPage;
    ActionsGamesPage actionsGamesPage;
    AgeCheckPage ageCheckPage;
    GamePage gamePage;
    InstallPage installPage;

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
    public void findSalesGames(){
        actionsGamesPage.fillGameList();
        /*if(actionsGamesPage.ifSalesNotExit()){
           actionsGamesPage.showMoreGames();
           return findSalesGames();
        }*/
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

/*    @Step("Check is needed page")
    public boolean isAgeCheckPage(){
        return ageCheckPage.isAgeCheckPage(driver.getCurrentUrl());
    }*/

    @Step("Check if AgeCheckPage contains select block")
    public boolean isSelectBlockDisplayed(){
        return ageCheckPage.isAgeSelectDisplayed();
    }

    @Step("Create valid date to pass the ageCheck")
    public void inputValidDate(long agePassVal){
        ageCheckPage.findAgeSelects();
        LocalDate startDate = LocalDate.of(ageCheckPage.findBoundaryAgeValue(), 1,1);
        LocalDate validDate = DateUtil.generateValidDate(startDate, agePassVal);
        ageCheckPage.selectDay(validDate.getDayOfMonth());
        ageCheckPage.selectMonth(validDate.getMonth().toString());
        ageCheckPage.selectYear(validDate.getYear());
    }

    @Step("Try open game page")
    public void openGamePageFromAgeCheck(){
        ageCheckPage.openGamePage();
    }

    @Step("Get cost data about game")
    public Game getGameData(String gameName){
        gamePage.findGame(gameName);
        return GameUtil.convertToGame(gameName, gamePage.getGameSale(), gamePage.getGameFinalPrice(), gamePage.getGameOrigPrice());
    }

    @Step("Check if games final price equals")
    public boolean compareGamesByFinalPrice(Game gameFromMenu, Game gameFromPage){
        return gameFromMenu.getFinalPrice().equals(gameFromPage.getFinalPrice());
    }

    @Step("Check if games orig price equals")
    public boolean compareGamesByOrigPrice(Game gameFromMenu, Game gameFromPage){
        return gameFromMenu.getOriginPrice().equals(gameFromPage.getOriginPrice());
    }

    @Step("Check if games sales equals")
    public boolean compareGamesBySale(Game gameFromMenu, Game gameFromPage){
        return gameFromMenu.getSale()==gameFromPage.getSale();
    }

    @Step("Download steam installer")
    public void downloadInstaller(){
        gamePage.openInstallPage();
        installPage.downloadInstaller();
    }

    @Step("Check if installer download")
    public boolean isFileDownload(String downloadPath){
        String fileName = installPage.getFileName();
        do {
            if (FileUtil.isFileDownloaded(downloadPath, fileName)) {
                return true;
            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }while (false);
    }

}
