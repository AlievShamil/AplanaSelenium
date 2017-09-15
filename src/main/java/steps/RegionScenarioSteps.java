package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegionScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();

    @When("^выполнено нажатие выбора региона")
    public void clickSelectRegion() {
        mainPageSteps.clickRegion();
    }
    @And("^выбран регион - \"(.+)\"$")
    public void chooseRegion(String regionName) {
        mainPageSteps.chooseRegion(regionName);
    }

    @Then("^на главной странице отображается \"(.+)\"")
    public void checkRegionName(String regionName) {
        mainPageSteps.checkRegion(regionName);
    }

    @When("^выполнен скролл до footer объекта на главной странице")
    public void scrollPage() {
        mainPageSteps.scrollPage();
    }

    @Then("^footer содержит значки соц. сетей")
    public void checkSocialNetworIcons() {
        mainPageSteps.checkElements();
    }





}
