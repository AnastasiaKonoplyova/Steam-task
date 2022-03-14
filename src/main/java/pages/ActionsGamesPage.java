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
import java.util.stream.Collectors;

public class ActionsGamesPage extends PageObject {

    private String gamesLocator = "%s//ancestor::div[contains(@class,'SaleItemBrowserRow')]";
    private String gameParamLocator = "//div[contains(@class,'%s')]";
    private String gameByNameLocator = "//a//*[text()='%s']";
    @FindBy(xpath = "//div[contains(@class,'SelectedFlavor')]//following-sibling::div")
    WebElementFacade topSellersBtn;
    @FindBy(xpath = "//button[contains(@class, 'ShowContents')]")
    WebElementFacade nextPageBtn;
    @FindBy(xpath = "//div[contains(@class,'FacetedBrowseItems')]")
    WebElementFacade gamesContainer;
    List<WebElementFacade> gameWebList;

    public boolean ifSalesNotExit(){
        return gameWebList.isEmpty();
    }

    public void fillGameList(){
        gamesContainer.waitUntilVisible();
        gameWebList = findEach(By.xpath(String.format(gamesLocator,
                String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc"))))).collect(Collectors.toList());
    }

    public void showMoreGames(){
        nextPageBtn.click();
        nextPageBtn.waitUntilEnabled();
    }

    public List<Game> getGames(){
        ArrayList<Game> gameList = new ArrayList<>();
        for (WebElementFacade element:
             gameWebList) {
            System.out.println(element.getText());
            gameList.add(GameUtil.convertToGame(getGameName(element), getGameSale(element),
                    getGameFinalPrice(element), getGameOrigPrice(element)));
        }
        for (Game game:
             gameList) {
            System.out.println(game.toString());
        }
        return gameList;
    }

    public void openGamePage(Game game){
        find(By.xpath(String.format(gameByNameLocator, game.getName()))).click();
    }

    public void openTopSellers(){
        topSellersBtn.waitUntilEnabled().click();
    }

    private int getGameSale(WebElementFacade game){
        String buf = game.thenFind(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc"))).getText();
        System.out.println("sale"+ String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc")));
        return StringUtil.getIntValue(buf);
    }

    private String getGameOrigPrice(WebElementFacade game){
        String buf =game.findBy(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("origPriceLoc")))).getText();
        System.out.println("orPR"+ String.format(gameParamLocator, JSONReader.getTestDataJSON("origPriceLoc")));
        return buf;
    }

    private String getGameName(WebElementFacade game){
        String buf =game.thenFind(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("nameGameLoc"))).getText();
        System.out.println("name"+ String.format(gameParamLocator, JSONReader.getTestDataJSON("nameGameLoc")));
        return buf;
    }

    private String getGameFinalPrice(WebElementFacade game){
        String buf =game.findBy(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("finalPriceLoc")))).getText();
        System.out.println("fnPR"+ String.format(gameParamLocator, JSONReader.getTestDataJSON("finalPriceLoc")));
        return buf;
    }
}