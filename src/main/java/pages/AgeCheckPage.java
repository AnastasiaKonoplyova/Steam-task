package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class AgeCheckPage extends PageObject {

    private final String urlPart = "agecheck";
    private String selectParamLocator = "//select[contains(@id,'%s')]";
    private String selectBlockLocator = "//div[contains(@class,'birthday_selector')]";
    @FindBy(xpath = "//div[@class='agegate_text_container btns']/a[@href='#']")
    private WebElementFacade viewPageBtn;
    private WebElementFacade ageDaySelect;
    private WebElementFacade ageMonthSelect;
    private WebElementFacade ageYearSelect;

    public boolean isAgeCheckPage(String url){
        return url.contains(urlPart);
    }

    public void findAgeSelects(){
        ageDaySelect = find(By.xpath(String.format(selectParamLocator, "Day")));
        ageMonthSelect = find(By.xpath(String.format(selectParamLocator, "Month")));
        ageYearSelect = find(By.xpath(String.format(selectParamLocator, "Year")));
    }

    public int findBoundaryAgeValue(){
        return Integer.getInteger(ageYearSelect.getSelectOptions().get(0));
    }

    public void selectDay(int day){
        ageDaySelect.selectByValue(String.valueOf(day));
    }

    public void selectMonth(String month){
        ageMonthSelect.selectByValue(month);
    }

    public void selectYear(int year){
        ageYearSelect.selectByValue(String.valueOf(year));
    }

    public void openGamePage(){
        viewPageBtn.click();
    }

    public boolean isAgeSelectDisplayed(){
        return find(By.xpath(selectBlockLocator)).isDisabled();
    }
}
