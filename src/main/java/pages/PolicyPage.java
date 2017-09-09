package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyPage extends BasePage {
    @FindBy(xpath = "//div[@class='b-form-box-block']")
    private WebElement amountOfInsuranceCoverage;

    @FindBy(xpath = "//span[@ng-click='save()']")
    private WebElement issueBtn;

    public PolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkAmountOfCoverage(String itemName) {
        amountOfInsuranceCoverage.findElement(By.xpath("//div[contains(text(),'" + itemName + "')]")).click();
    }

    public void clickIssueBtn() {
        issueBtn.click();
    }

}
