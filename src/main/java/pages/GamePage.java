package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.TestParam;
import utils.StringUtil;

public class GamePage extends BasePage {

    private final String GAME_PARAM_LOCATOR = ".//following-sibling::div//div[contains(@class,'%s')]";
    @FindBy (className = "game_area_purchase_game")
    WebElementFacade game;


    public String getGameOrigPrice(){
        return game.findElement(By.xpath(
                String.format(GAME_PARAM_LOCATOR, TestParam.ORIG_PRICE.getTitle()))).getText();
    }

    public int getGameSale(){
        return StringUtil.getIntValue(game.findElement(By.xpath(
                String.format(GAME_PARAM_LOCATOR, TestParam.SALE.getTitle()))).getText());
    }

    public String getGameFinalPrice(){
        return game.findElement(By.xpath(
                String.format(GAME_PARAM_LOCATOR, TestParam.FINAL_PRICE.getTitle()))).getText().split(" ")[0];
    }


}
