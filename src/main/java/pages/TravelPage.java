package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelPage extends BasePage {
    @FindBy(xpath = "//div[@class='sbrf-rich-wrapper']//img[contains(@src,'travel')]")
    public WebElement issueBtn;

    public TravelPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void clickIssueBtn() {
        issueBtn.click();
    }

    public String getTitle() {
       return driver.getTitle();
    }
}
