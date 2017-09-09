package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import static org.junit.Assert.assertEquals;

public class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;


    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }
}
