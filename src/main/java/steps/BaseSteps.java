package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
