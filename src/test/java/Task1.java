
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
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testInsuranceTest2() throws Exception {
        driver.get(baseUrl + "/ru/person");
        driver.findElement(By.cssSelector("button.header-offices__btn")).click();
        new Select(driver.findElement(By.xpath("(//select[@name='region'])[2]"))).selectByVisibleText("Нижегородская область");
        driver.findElement(By.cssSelector("button.header-offices__btn")).click();

        try {
            assertEquals("Нижегородская область",
                    driver.findElement(By.xpath(".//*[@id='main']/div/div/div/div/div/div/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div/a/span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath(".//*[@id='main']/div/div/div/div/div/div/div[4]/div/div[2]/div/div/button")).click();

        WebElement webElem = driver.findElement(By.xpath("//*[@class='social social_section_person']//div"));
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
