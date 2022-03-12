package pages;

import model.Game;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.GameUtil;
import utils.JSONReader;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class ActionsGamesPage extends PageObject {

    private final String gamesLocator = "//div[contains(@id,'TopSellers')]//a";
    private String gameParamLocator = "//div[contains(@class,'%s')]";
    private String gameByNameLocator = "//a//*[text()='%s']";
    @FindBy(xpath = "//div[@id='tab_select_TopSellers']")
    private WebElementFacade topSellersBtn;
    @FindBy(xpath = "//span[@id='TopSellers_btn_next']")
    private WebElementFacade nextPageBtn;
    private ListOfWebElementFacades gameWebList;

    public boolean ifSalesExit(){
        for (WebElementFacade element:
                gameWebList) {
            if (element.findElement(By.xpath(String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc")))).isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public void fillGameList(){
        gameWebList = findAll(By.xpath(gamesLocator));
    }

    public void turnMenu(){
        nextPageBtn.click();
    }

    public List<Game> getGames(){
        ArrayList<Game> gameList = new ArrayList<>();
        for (WebElementFacade element:
             gameWebList) {
            gameList.add(GameUtil.convertToGame(getGameName(element),getGameSale(element),
                    getGameFinalPrice(element),getGameOrigPrice(element)));
        }
        return gameList;
    }

    private int getGameSale(WebElement game){
        List<WebElement> sales = game.findElements(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc"))));
        return  sales.isEmpty() ? 0 : StringUtil.getIntValue(sales.get(sales.size()-1).getText());
    }

    public void openGamePage(Game game){
        find(By.xpath(String.format(gameByNameLocator, game.getName()))).click();
    }

    public void openTopSellers(){
        topSellersBtn.click();
    }

    private String getGameOrigPrice(WebElement game){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("origPriceLoc")))).getText();
    }

    private String getGameName(WebElement game){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("nameGameLoc")))).getText();
    }

    private String getGameFinalPrice(WebElement game){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("final_price")))).getText();
    }
}