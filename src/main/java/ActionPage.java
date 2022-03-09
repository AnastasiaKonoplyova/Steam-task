import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;

import java.util.ArrayList;

@DefaultUrl("https://store.steampowered.com/category/action/")
public class ActionPage {

    @FindBy(xpath = "//div[@id='tab_select_TopSellers']")
    private WebElementFacade topSellersBtn;

    @FindBy(xpath = "//div[@id='TopSellersTable']//div[@class='discount_pct']")
    private ArrayList<WebElementFacade> salesList;
    private String gameLocator = "//div[@id='TopSellersTable']//div[@class='discount_pct' and contains(text(),'%d')]//ancestor::a";

}