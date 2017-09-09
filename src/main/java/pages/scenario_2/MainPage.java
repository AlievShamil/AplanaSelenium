package pages.scenario_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'header_more_nav')]")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class='alt-menu-collapser__hidder']")
    WebElement menuInsurance;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath("//span[contains(@class,'multiline')]/*[contains(text(),'"+itemName+"')]")).click();
    }

    public void selectInsuranceItem(String itemName){
        menuInsurance.findElement(By.xpath("//li[contains(@class,'item_leaf')]//a[contains(text(),'"+itemName+"')]")).click();
    }
}
