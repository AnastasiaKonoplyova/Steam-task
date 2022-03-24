package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang.StringUtils;

public class AgeCheckPage extends BasePage {

    private final String AGE_CHECK_URL_PART = "agecheck";
    @FindBy(xpath = "//div[@class='agegate_text_container btns']/a[@href='#']")
    WebElementFacade viewPageBtn;
    @FindBy(id = "ageDay")
    WebElementFacade ageDaySelect;
    @FindBy(id = "ageMonth")
    WebElementFacade ageMonthSelect;
    @FindBy(id = "ageYear")
    WebElementFacade ageYearSelect;

    public boolean isAgeCheckPage(){
        return getDriver().getCurrentUrl().contains(AGE_CHECK_URL_PART);
    }

    public int findBoundaryAgeValue(){
        return Integer.parseInt(ageYearSelect.getSelectOptions().get(0));
    }

    public void selectDay(int day){
        ageDaySelect.selectByValue(String.valueOf(day));
    }

    public void selectMonth(String month){
        ageMonthSelect.selectByValue(StringUtils.capitalize(month.toLowerCase()));
    }

    public void selectYear(int year){
        ageYearSelect.selectByValue(String.valueOf(year));
    }

    public void openGamePage(){
        viewPageBtn.click();
    }

}
