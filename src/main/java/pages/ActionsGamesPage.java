package pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;

public class ActionsGamesPage extends PageObject {

    private final String gamesLocator = "//div[contains(@id,'TopSellers')]//a";
    private final String saleLocator = "//div[contains(@class,'discount_pct')]";
    private final String cheapGameLocator = "//div[contains(@class,'discount_pct') and contains(text(),'%d')]";
    private final String gameOriginPriceLocator = "//div[contains(@class,'original_price')]";
    private final String gameNameLocator = "//div[contains(@class,'item_name')]";
    private final String gameFinalPriceLocator = "//div[contains(@class,'final_price')";
    @FindBy(xpath = "//div[@id='tab_select_TopSellers']")
    private WebElementFacade topSellersBtn;
    @FindBy(xpath = "//span[@id='TopSellers_btn_next']")
    private WebElementFacade nextPageBtn;
    private ListOfWebElementFacades gamesList;
    private WebElementFacade gameLn;

    public boolean ifSalesExit(){
        for (WebElementFacade element:
             gamesList) {
            if (element.findElement(By.xpath(saleLocator)).isDisplayed()){
                return true;
            }
        }
        return false;
    }

    public void fillGameList(){
        gamesList = findAll(By.xpath(gamesLocator));
    }

    public void turnMenu(){
        nextPageBtn.click();
    }

    public Integer getMaxSale(){
        ArrayList<Integer> salesValueList = new ArrayList<>();
        for (WebElementFacade element:
                gamesList) {
            salesValueList.add(getIntegerValue(element.findElement(By.xpath(saleLocator)).getText()));
        }
        return salesValueList.stream().max(Comparator.naturalOrder()).get();
    }

    private Integer getIntegerValue(String textValue){
        return Integer.getInteger(textValue.substring(0,textValue.length()-1));
    }

    public void findCheapestGame(int sale){
        for (WebElementFacade element:
                gamesList) {
            if (element.findElement(By.xpath(String.format(cheapGameLocator, sale))).isDisplayed()){
                gameLn = element;
            }
        }
    }

    public void openTopSellers(){
        topSellersBtn.click();
    }

    public String getGameOrigPrice(){
        return gameLn.findElement(By.xpath(gameOriginPriceLocator)).getText();
    }

    public String getGameName(){
        return gameLn.findElement(By.xpath(gameNameLocator)).getText();
    }

    public String getGameFinalPrice(){
        return gameLn.findElement(By.xpath(gameFinalPriceLocator)).getText();
    }
}