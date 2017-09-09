package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class='alt-menu-collapser__hidder']")
    WebElement menuInsurance;

    @FindBy(xpath = "//*[contains(@class,'icon_type_fb')]")
    public WebElement facebook;

    @FindBy(xpath = "//*[contains(@class,'icon_type_tw')]")
    public WebElement twitter;

    @FindBy(xpath = "//*[contains(@class,'icon_type_yt')]")
    public WebElement youtube;

    @FindBy(xpath = "//*[contains(@class,'icon_type_ins')]")
    public WebElement instagram;

    @FindBy(xpath = "//*[contains(@class,'icon_type_vk')]")
    public WebElement vkontakte;

    @FindBy(xpath = "//*[contains(@class,'icon_type_ok')]")
    public WebElement odnoklassniki;

    @FindBy(xpath = "//a[@class='kit-link kit-link_color_black region-list__toggler']")
    public WebElement region;

    @FindBy(xpath = "//div[@class='region-list__modal-content']")
    public WebElement regionList;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5, 1000);
    }

    public void selectMenuItem(String itemName) {
        menuItems.findElement(By.xpath("//span[contains(@class,'multiline')]/*[contains(text(),'" + itemName + "')]")).click();
    }

    public void selectInsuranceItem(String itemName) {
        menuInsurance.findElement(By.xpath("//li[contains(@class,'item_leaf')]//a[contains(text(),'" + itemName + "')]")).click();
    }

    public void selectRegion(String value) {
        region.click();
        wait.until(ExpectedConditions.visibilityOf(regionList));
        regionList.findElement(By.xpath("//a[contains(text(),'" + value + "')]")).click();
    }

    public void checkRegion(String value) {
        wait.until(ExpectedConditions.invisibilityOf(region));
        assertEquals(value, region.getText());
    }

    public void scrollToFooter() {
        WebElement element = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-social']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void checkSocialNetworkIcon(WebElement element) {
        assertTrue(element.isDisplayed());
    }
}
