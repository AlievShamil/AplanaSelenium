package steps;

import pages.InsurancePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurancePolicyPageSteps {

    @Step("Выбрана сумма страховой защиты - {0}")
    public void chooseInsurancePolicy(String value) {
        new InsurancePolicyPage().checkAmountOfCoverage(value);
    }

    @Step("Нажато Оформить")
    public void clickIssueButton() {
        new InsurancePolicyPage().clickIssueBtn();
    }
}
