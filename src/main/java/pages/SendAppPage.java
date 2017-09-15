package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.getDriver;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//div[contains(@ng-show,'tryNext && myForm.$invalid')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//fieldset[contains(@class,'fieldset-splash')]")
    private WebElement sex;

    @FindBy(name = "insured0_surname")
    private WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    private WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    private WebElement insuredBirthDate;

    @FindBy(name = "surname")
    private WebElement surname;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "middlename")
    private WebElement middlename;

    @FindBy(name = "birthDate")
    private WebElement birthDate;

    @FindBy(name = "passport_series")
    private WebElement passportSeries;

    @FindBy(name = "passport_number")
    private WebElement passportNumber;

    @FindBy(name = "issueDate")
    private WebElement issueDate;

    @FindBy(name = "issuePlace")
    private WebElement issuePlace;

    public SendAppPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Surname":
                fillField(insuredSurname, value);
                break;
            case "Name":
                fillField(insuredName, value);
                break;
            case "Birth Date":
                fillField(insuredBirthDate, value);
                break;
            case "Фамилия":
                fillField(surname, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Отчество":
                fillField(middlename, value);
                break;
            case "Дата рождения":
                fillField(birthDate, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Кем выдан":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Surname":
                return insuredSurname.getAttribute("value");
            case "Name":
                return insuredName.getAttribute("value");
            case "Birth Date":
                return insuredBirthDate.getAttribute("value");
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middlename.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void scrollViewAndClick() {
        WebElement webElem = getDriver().findElement(By.xpath("//*[@class='contactsContainer']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElem);
        getDriver().findElement(By.xpath("//*[text()='Продолжить']")).click();
    }

    public void checkFieldErrorMessage(String value) {
        assertTrue(errorMessage.isDisplayed() && errorMessage.getText().equals(value));
    }


}
