package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.JSONReader;
import utils.StringUtil;

public class GamePage extends PageObject {

    private String gameLocator = "//*[text()='Buy %s']";
    private String gameParamLocator = "//following-sibling::div//div[contains(@class,'%s')]";
    private WebElementFacade game;
    private WebElementFacade installLn = find(By.xpath("//a[contains(@class,'installsteam')]"));

    public void findGame(String gameName){
        game = find(By.xpath(String.format(gameLocator, gameName)));
    }

    public String getGameOrigPrice(){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("origPriceLoc")))).getText();
    }

    public int getGameSale(){
        return StringUtil.getIntValue(game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("discount_pct")))).getText());
    }

    public String getGameFinalPrice(){
        return game.findElement(By.xpath(
                String.format(gameParamLocator, JSONReader.getTestDataJSON("final_price")))).getText();
    }

    public void openInstallPage(){
        installLn.click();
    }

}
