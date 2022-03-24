package pages;

import model.Game;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import parameters.GameParameters;
import utils.GameUtil;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class ActionsGamesPage extends BasePage {

    private final String GAMES_WITH_SALE_LOCATOR = ".//div[contains(@class,'discount_pct')]//ancestor::a";
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

    public List<Game> getGamesWithSale(){
        ListOfWebElementFacades webList = gamesContainer.thenFindAll(By.xpath(GAMES_WITH_SALE_LOCATOR));
        ArrayList<Game> gameList = new ArrayList<>();
        for (WebElementFacade element:
                webList) {
            gameList.add(GameUtil.convertToGame(getGameValue(element, GameParameters.NAME),
                    getGameValue(element, GameParameters.SALE), getGameValue(element, GameParameters.FINAL_PRICE),
                    getGameValue(element,GameParameters.ORIG_PRICE)));
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

    private String getGameValue(WebElementFacade game, GameParameters param){
        if(param.equals(GameParameters.NAME)) {
            return game.findBy(By.xpath(
                    String.format(GAMES_PARAM_LOCATOR, param.getTitle()))).getText();
        }
        return StringUtil.getNumberValue(game.findBy(By.xpath(
                String.format(GAMES_PARAM_LOCATOR, param.getTitle()))).getText());
    }
}