package pages;

import model.Game;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import utils.GameUtil;
import utils.StringUtil;
import utils.TestParam;

import java.util.ArrayList;
import java.util.List;

public class ActionsGamesPage extends BasePage {

    private final String GAMES_LOCATOR = ".//div[contains(@class,'discount_pct')]//ancestor::a";
    private final String GAMES_PARAM_LOCATOR = ".//div[contains(@class,'%s')]";
    private final String GAMES_BY_NAME_LOCATOR = ".//*[text()='%s']//ancestor::a";
    @FindBy(id = "tab_select_TopSellers")
    WebElementFacade topSellersBtn;
    @FindBy(id = "TopSellers_btn_next")
    WebElementFacade nextPageBtn;
    @FindBy(id = "tab_content_TopSellers")
    WebElementFacade gamesContainer;

    public void showMoreGames(){
        nextPageBtn.click();
    }

    public List<Game> getGames(){
        ListOfWebElementFacades webList = gamesContainer.thenFindAll(By.xpath(GAMES_LOCATOR));
        ArrayList<Game> gameList = new ArrayList<>();
        for (WebElementFacade element:
                webList) {
            gameList.add(GameUtil.convertToGame(getGameName(element), getGameSale(element),
                    getGameFinalPrice(element), getGameOrigPrice(element)));
        }
        webList.clear();
        return gameList;
    }

    public void openGamePage(Game game){
        gamesContainer.find(By.xpath(String.format(GAMES_BY_NAME_LOCATOR, game.getName()))).click();
    }

    public void openTopSellers(){
        topSellersBtn.waitUntilEnabled().click();
    }

    private int getGameSale(WebElementFacade game){
        return StringUtil.getIntValue(game.findBy(
                String.format(GAMES_PARAM_LOCATOR, TestParam.SALE.getTitle())).getText());
    }

    private String getGameOrigPrice(WebElementFacade game){
        return game.findBy(By.xpath(
                String.format(GAMES_PARAM_LOCATOR, TestParam.ORIG_PRICE.getTitle()))).getText();
    }

    private String getGameName(WebElementFacade game){
        return game.findBy(
                String.format(GAMES_PARAM_LOCATOR, TestParam.NAME.getTitle())).getText();
    }

    private String getGameFinalPrice(WebElementFacade game){
        return game.findBy(By.xpath(
                String.format(GAMES_PARAM_LOCATOR, TestParam.FINAL_PRICE.getTitle()))).getText();
    }
}