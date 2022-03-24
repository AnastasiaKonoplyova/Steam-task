package steps;

import net.thucydides.core.annotations.Step;
import pages.MainPage;
import parameters.GenreMenuParam;
import parameters.MainMenuParam;

public class MainPageSteps {

    MainPage mainPage;

    @Step("Starting test, open main page and then actions games page")
    public void openActionsPage(){
        mainPage.open();
        mainPage.openGenrePage(MainMenuParam.GENRE_MENU, GenreMenuParam.GAME_ACTION_GENRE);
    }
}
