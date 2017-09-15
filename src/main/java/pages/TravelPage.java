package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.getDriver;

public class TravelPage extends BasePage {
    @FindBy(xpath = "//div[@class='sbrf-rich-wrapper']//img[contains(@src,'travel')]")
    public WebElement issueBtn;

    public TravelPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public void compareTitleName(String expectedTitle) {
        String actualTitle = getDriver().getTitle();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
