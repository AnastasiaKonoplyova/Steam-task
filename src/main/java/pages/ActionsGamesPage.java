package pages;

import model.Game;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import utils.GameUtil;
import utils.JSONReader;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class ActionsGamesPage extends PageObject {

    private String gamesLocator = ".//div[contains(@class,'discount_pct')]//ancestor::a";
    private String gameParamLocator = ".//div[contains(@class,'%s')]";
    private String gameByNameLocator = ".//*[text()='%s']//ancestor::a";
    @FindBy(xpath = "//div[@id='tab_select_TopSellers']")
    WebElementFacade topSellersBtn;
    @FindBy(xpath = "//span[@id='NewReleases_btn_next']")
    WebElementFacade nextPageBtn;
    @FindBy(xpath = "//div[@id='tab_content_TopSellers']")
    WebElementFacade gamesContainer;
    ListOfWebElementFacades gameWebList;

    public boolean ifSalesNotExit(){
        return gameWebList.isEmpty();
    }

    public void fillGameList(){
        gameWebList = gamesContainer.thenFindAll(By.xpath(gamesLocator));
    }

    public void showMoreGames(){
        nextPageBtn.click();
        nextPageBtn.waitUntilEnabled();
    }

    public List<Game> getGames(){
        ArrayList<Game> gameList = new ArrayList<>();
        for (WebElementFacade element:
             gameWebList) {
            gameList.add(GameUtil.convertToGame(getGameName(element), getGameSale(element),
                    getGameFinalPrice(element), getGameOrigPrice(element)));
        }
        return gameList;
    }

    public void openGamePage(Game game){
        gamesContainer.find(By.xpath(String.format(gameByNameLocator, game.getName()))).click();
    }

    public void openTopSellers(){
        topSellersBtn.waitUntilEnabled().click();
    }

    private int getGameSale(WebElementFacade game){
        return StringUtil.getIntValue(game.findBy(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc"))).getText());
    }

    private String getGameOrigPrice(WebElementFacade game){
        return game.findBy(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("origPriceLoc")))).getText();
    }

    private String getGameName(WebElementFacade game){
        return game.findBy(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("nameGameLoc"))).getText();
    }

    private String getGameFinalPrice(WebElementFacade game){
        return game.findBy(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("finalPriceLoc")))).getText();
    }
}