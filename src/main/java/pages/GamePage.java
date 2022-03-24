package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import parameters.GameParameters;
import utils.StringUtil;

public class GamePage extends BasePage {

    private final String GAME_PARAM_LOCATOR = ".//following-sibling::div//div[contains(@class,'%s')]";
    @FindBy (className = "game_area_purchase_game")
    WebElementFacade game;


    public String getGameValue(GameParameters param){
        return StringUtil.getNumberValue(game.findBy(By.xpath(
                String.format(GAME_PARAM_LOCATOR, param.getTitle()))).getText());
    }

}
