package pages.scenario_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BasePage {
    protected WebDriver driver;

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }
}
