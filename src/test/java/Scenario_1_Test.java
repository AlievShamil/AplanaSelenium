

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Scenario_1_Test extends BaseTest {

    @Ignore
    @Test
    public void testInsuranceTest2() throws Exception {
        driver.get(baseUrl + "ru/person");
        driver.findElement(By.cssSelector("span.region-list__arrow")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 1, 3000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//span[@class='region-list__arrow']"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Нижегородская область')]")).click();


        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//span[@class='region-list__name']"))
        ));
        assertEquals("Нижегородская область",
                driver.findElement(By.xpath("//span[@class='region-list__name']")).getText());

        WebElement webElem = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-social']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);

        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_fb')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_tw')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_yt')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_ins')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_vk')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_ok')]")));
    }

}
