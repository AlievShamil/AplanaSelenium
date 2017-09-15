package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]")
    private WebElement menuItems;

    @FindBy(xpath = "//div[@class='alt-menu-collapser__hidder']")
    private WebElement menuInsurance;

    @FindBy(xpath = "//*[contains(@class,'icon_type_fb')]")
    private WebElement facebook;

    @FindBy(xpath = "//*[contains(@class,'icon_type_tw')]")
    private WebElement twitter;

    @FindBy(xpath = "//*[contains(@class,'icon_type_yt')]")
    private WebElement youtube;

    @FindBy(xpath = "//*[contains(@class,'icon_type_ins')]")
    private WebElement instagram;

    @FindBy(xpath = "//*[contains(@class,'icon_type_vk')]")
    private WebElement vkontakte;

    @FindBy(xpath = "//*[contains(@class,'icon_type_ok')]")
    private WebElement odnoklassniki;

    @FindBy(xpath = "//div[contains(@class,'header_contacts')]//a[contains(@class,'toggler')]")
    public WebElement menuRegion;

    @FindBy(xpath = "////span[@class='region-search-box__option']")
    public WebElement regionItem;

    @FindBy(xpath = "//div[@class='region-list__modal-content']")
    public WebElement regionList;

    private List<WebElement> elements = Arrays.asList(
            facebook, twitter, youtube, instagram, vkontakte, odnoklassniki);

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void selectMenuItem(String itemName) {
        String subStr = itemName.substring(0, 17);
        new WebDriverWait(getDriver(), 5, 1000).until(ExpectedConditions.visibilityOf(
                menuItems.findElement(By.xpath("//span[contains(@class,'multiline')]/*[contains(text(),'" + subStr + "')]"))
        )).click();
    }

    public void selectInsuranceItem(String itemName) {
        menuInsurance.findElement(By.xpath("//li[contains(@class,'item_leaf')]//a[contains(text(),'" + itemName + "')]")).click();
    }

    public void selectRegion(String regionName) {
        new WebDriverWait(getDriver(), 5, 1000).until(ExpectedConditions.visibilityOf(
                regionList.findElement(By.xpath("//a[contains(text(),'" + regionName + "')]"))
        )).click();
    }

    public void checkRegion(String value) {
        boolean staleElement = true;
        while (staleElement) {
            try {
                assertEquals(value, menuRegion.getAttribute("title"));
                staleElement = false;

            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    public void scrollToFooter() {
        WebElement element = getDriver().findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-social']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void checkElements() {
        for (WebElement element : elements) {
            assertTrue(element.isDisplayed());
        }
    }

}
