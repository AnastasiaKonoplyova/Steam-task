package steps;

import net.thucydides.core.annotations.Step;
import pages.AgeCheckPage;
import utils.DateUtil;
import parameters.TestParam;

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

    private void inputValidDate(){
        LocalDate startDate = LocalDate.of(ageCheckPage.findBoundaryAgeValue(), 1,1);
        LocalDate validDate = DateUtil.generateValidDate(startDate, Long.parseLong(TestParam.AGE_RANGE.getTitle()));
        ageCheckPage.selectDay(validDate.getDayOfMonth());
        ageCheckPage.selectMonth(validDate.getMonth().toString());
        ageCheckPage.selectYear(validDate.getYear());
    }

}
