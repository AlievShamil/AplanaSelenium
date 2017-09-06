
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Task1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testInsuranceTest2() throws Exception {
        driver.get(baseUrl + "/ru/person");
        driver.findElement(By.cssSelector("span.region-list__arrow")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 1, 3000);

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//span[@class='region-list__arrow']"))
        ));
        driver.findElement(By.xpath("//a[contains(text(),'Нижегородская область')]")).click();

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//span[@class='region-list__name']"))
        ));
        assertEquals("Нижегородская область", driver.findElement(By.xpath("//span[@class='region-list__name']")).getText());

        WebElement webElem = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-social']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);

        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_fb')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_tw')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_yt')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_ins')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_vk')]")));
        assertTrue(isElementPresent(By.xpath("//*[contains(@class,'icon_type_ok')]")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
