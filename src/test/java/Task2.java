
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Task2 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test2() throws Exception {
        driver.get(baseUrl + "/ru/person");
        Wait<WebDriver> wait = new WebDriverWait(driver, 1, 3000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//*//ul/li[5]/a/span")
        )));
        driver.findElement(By.xpath("//*//div/div/ul/li[5]/a/span")).click();
        driver.findElement(By.linkText("Страхование путешественников")).click();

        assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle());
        driver.findElement(By.cssSelector("p > a > img")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();
        driver.findElement(By.cssSelector("span.b-continue-btn")).click();
        driver.findElement(By.name("insured0_surname")).clear();
        driver.findElement(By.name("insured0_surname")).sendKeys("PETROV");
        driver.findElement(By.name("insured0_name")).clear();
        driver.findElement(By.name("insured0_name")).sendKeys("PETR");
        driver.findElement(By.name("insured0_birthDate")).clear();
        driver.findElement(By.name("insured0_birthDate")).sendKeys("01.01.2001");
        driver.findElement(By.name("surname")).clear();
        driver.findElement(By.name("surname")).sendKeys("Иванов");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Иван");
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys("Иванович");
        driver.findElement(By.name("birthDate")).clear();
        driver.findElement(By.name("birthDate")).sendKeys("02.02.1999");
        driver.findElement(By.name("male")).click();
        driver.findElement(By.name("passport_series")).clear();
        driver.findElement(By.name("passport_series")).sendKeys("1111");
        driver.findElement(By.name("passport_number")).clear();
        driver.findElement(By.name("passport_number")).sendKeys("222222");
        driver.findElement(By.name("issueDate")).clear();
        driver.findElement(By.name("issueDate")).sendKeys("05.05.2015");
        driver.findElement(By.name("issuePlace")).click();
        driver.findElement(By.name("issuePlace")).clear();
        driver.findElement(By.name("issuePlace")).sendKeys("бла-бла-бла");

        assertEquals("PETROV", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("PETR", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("01.01.2001", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("02.02.1999", driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("1111", driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("222222", driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("05.05.2015", driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("бла-бла-бла", driver.findElement(By.name("issuePlace")).getAttribute("value"));

        WebElement webElem = driver.findElement(By.xpath("//*[@class='contactsContainer']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);
        driver.findElement(By.xpath("//*[@id='views']/section/form/section/section[5]/div[1]/span[2]")).click();

        assertEquals("Заполнены не все обязательные поля", driver.findElement(
                By.xpath("//div[contains(@ng-show,'tryNext && myForm.$invalid')]")).getText());
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
