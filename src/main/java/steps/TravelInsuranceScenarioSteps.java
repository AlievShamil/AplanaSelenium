package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class TravelInsuranceScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelPageSteps travelPageSteps = new TravelPageSteps();
    InsurancePolicyPageSteps policyPageSteps = new InsurancePolicyPageSteps();
    SendAppPageSteps sendAppPageSteps = new SendAppPageSteps();


    @When("^выполнено нажатие на \"(.+)\"$")
    public void clickMenuItem(String menuName) {
        mainPageSteps.clickMenuItem(menuName);
    }

    @And("^выбран пункт - \"(.+)\"$")
    public void selectMenuInsurance(String menuName) {
        mainPageSteps.selectInsuranceMenu(menuName);
    }

    @Then("^заголовок страницы равен \"(.+)\"$")
    public void checkTitle(String titleName) {
        travelPageSteps.checkTitleName(titleName);
    }

    @When("^выполнено нажатие на Оформить онлайн")
    public void clickOnCheckoutOnline(){
        travelPageSteps.clickBtn();
    }

    @When("^выбрана сумма страховой защиты - \"(.+)\"$")
    public void chooseAmountOfInsurance(String amount){
        policyPageSteps.chooseInsurancePolicy(amount);
    }

    @And("^выполнено нажатие на кнопку Оформить")
    public void clickBtnIssue(){
        policyPageSteps.clickIssueButton();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class,String.class)
                .forEach((field,value)->sendAppPageSteps.fillField(field, value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class,String.class)
                .forEach((field,value)->sendAppPageSteps.checkFillField(field, value));
    }

    @And("^выполнено нажатие на продолжить")
    public void clickContinuBtn() {
        sendAppPageSteps.clickContinue();
    }
    @Then("^появилось сообщение - \"(.+)\"$")
    public void checkErrorMessage(String errMsg) {
        sendAppPageSteps.checkErrorMessage(errMsg);
    }


}
