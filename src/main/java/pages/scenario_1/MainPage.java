package pages.scenario_1;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage{
    private WebDriver driver;
    private Wait<WebDriver> wait;

    @FindBy(xpath = "//*[contains(@class,'icon_type_fb')]")
    public By facebook;

    @FindBy(xpath = "//*[contains(@class,'icon_type_tw')]")
    public By twitter;

    @FindBy(xpath = "//*[contains(@class,'icon_type_yt')]")
    public By youtube;

    @FindBy(xpath = "//*[contains(@class,'icon_type_ins')]")
    public By instagram;

    @FindBy(xpath = "//*[contains(@class,'icon_type_vk')]")
    public By vkontakte;

    @FindBy(xpath = "//*[contains(@class,'icon_type_ok')]")
    public By odnoklassniki;

    @FindBy(xpath = "//span[@class='region-list__name']")
    public WebElement region;

    @FindBy(xpath = "//div[@class='region-list__modal-content']")
    public WebElement regionList;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5, 1000);
    }

    public void selectRegion(String value) {
        region.click();
        wait.until(ExpectedConditions.visibilityOf(regionList));
        regionList.findElement(By.xpath("//a[contains(text(),'" + value + "')]")).click();
    }

    public void checkRegion(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(region));
        assertEquals(value,region.getText());
    }

    public void scrollToFooter(){
        WebElement element = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-social']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void checkSocialNetworkIcon(By by) {
        assertTrue(isElementPresent(by));
    }


}
