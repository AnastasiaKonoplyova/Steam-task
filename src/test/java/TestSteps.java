import net.thucydides.core.annotations.Step;
import pages.ActionsGamesPage;
import pages.MainPage;

public class TestSteps {

    MainPage mainPage;
    ActionsGamesPage actionsGamesPage;

    @Step("Starting test, open main page and then actions games page")
    public void openActionsPage(){
        mainPage.open();
        mainPage.openActionPage();
    }

    @Step("Checkout tabs for top sellers")
    public void openTopSellers(){
        actionsGamesPage.openTopSellers();
    }

    @Step("Check if games with sales exist on the page")
    public boolean checkSales(){
        actionsGamesPage.fillGameList();
        return actionsGamesPage.ifSalesExit();
    }

    @Step()
    public void findCheapestGame(){
        actionsGamesPage.findCheapestGame(actionsGamesPage.getMaxSale());

    }
}
