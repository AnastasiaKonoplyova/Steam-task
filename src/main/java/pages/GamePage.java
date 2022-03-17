package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.JSONReader;
import utils.StringUtil;

public class GamePage extends PageObject {

    private String gameLocator = "//div[@class='game_area_purchase_game']";
    private String gameParamLocator = ".//following-sibling::div//div[contains(@class,'%s')]";
    private WebElementFacade game;
    @FindBy(xpath = "//a[contains(@class,'installsteam')]")
    WebElementFacade installLn;

    public void findGame(String gameName){
        game = find(By.xpath(String.format(gameLocator, gameName)));
    }

    public String getGameOrigPrice(){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("origPriceLoc")))).getText();
    }

    public int getGameSale(){
        return StringUtil.getIntValue(game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("saleGameLoc")))).getText());
    }

    public String getGameFinalPrice(){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("finalPriceLoc")))).getText().split(" ")[0];
    }

    public void openInstallPage(){
        installLn.click();
    }

}
