package steps;

import net.thucydides.core.annotations.Step;
import pages.MainPage;
import utils.TestParam;

public class MainPageSteps {

    MainPage mainPage;

    @Step("Starting test, open main page and then actions games page")
    public void openActionsPage(){
        mainPage.open();
        mainPage.openGenrePage(TestParam.SUBMENU.getTitle(),TestParam.GAME_GENRE.getTitle());
    }
}
