package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.BaseSteps.getDriver;

public class InsurancePolicyPage extends BasePage {
    @FindBy(xpath = "//div[@class='b-form-box-block']")
    private WebElement amountOfInsuranceCoverage;

    @FindBy(xpath = "//span[@ng-click='save()']")
    private WebElement issueBtn;

    public InsurancePolicyPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void checkAmountOfCoverage(String itemName) {
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
        new WebDriverWait(getDriver(),5,1000).until(ExpectedConditions.visibilityOf(
                amountOfInsuranceCoverage
        ));
        amountOfInsuranceCoverage.findElement(By.xpath("//div[contains(text(),'" + itemName + "')]")).click();
    }

    public void clickIssueBtn() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", issueBtn);
        issueBtn.click();
    }



}
