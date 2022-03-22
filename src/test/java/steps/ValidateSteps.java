package steps;

import model.Game;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import pages.AgeCheckPage;
import pages.WrongRegion;
import utils.DateUtil;
import utils.TestParam;

import java.time.LocalDate;

public class ValidateSteps {

    AgeCheckPage ageCheckPage;

    @Step("Check is needed page")
    public boolean isAgeCheckPage(){
        if(ageCheckPage.isAgeCheckPage()){
            inputValidDate();
            return true;
        }
        return false;
    }

    @Step("Create valid date to pass the ageCheck")
    private void inputValidDate(){
        LocalDate startDate = LocalDate.of(ageCheckPage.findBoundaryAgeValue(), 1,1);
        LocalDate validDate = DateUtil.generateValidDate(startDate, Long.parseLong(TestParam.AGE_RANGE.getTitle()));
        ageCheckPage.selectDay(validDate.getDayOfMonth());
        ageCheckPage.selectMonth(validDate.getMonth().toString());
        ageCheckPage.selectYear(validDate.getYear());
    }

}
