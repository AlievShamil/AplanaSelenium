import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Scenario_2_Test extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"PETROV", "PETR", "01.01.2001", "Иванов", "Иван", "Иванович",
                        "02.02.1999", "1111", "222222", "05.05.2015", "бла-бла-бла"},
                {"MEDVEDEV", "DMITRY", "11.11.1991", "Путин", "Владимир", "Владимирович",
                        "12.12.1991", "1234", "555555", "07.07.2017", "он вам не Димон"}
        });
    }

    @Parameterized.Parameter
    public String insuredSurname;

    @Parameterized.Parameter(1)
    public String insuredName;

    @Parameterized.Parameter(2)
    public String insuredBirthDate;

    @Parameterized.Parameter(3)
    public String surname;

    @Parameterized.Parameter(4)
    public String name;

    @Parameterized.Parameter(5)
    public String middlename;

    @Parameterized.Parameter(6)
    public String birthDate;

    @Parameterized.Parameter(7)
    public String passportSeries;

    @Parameterized.Parameter(8)
    public String passportNumber;

    @Parameterized.Parameter(9)
    public String issueDate;

    @Parameterized.Parameter(10)
    public String issuePlace;

    @Ignore
    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "ru/person");
        driver.findElement(
                By.xpath("//*//ul/li[5]/a/span"));
        driver.findElement(By.xpath("//*//div/div/ul/li[5]/a/span")).click();
        driver.findElement(By.linkText("Страхование путешественников")).click();

        assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle());

        driver.findElement(By.cssSelector("p > a > img")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();
        driver.findElement(By.cssSelector("span.b-continue-btn")).click();

        fillField(By.name("insured0_surname"), insuredSurname);
        fillField(By.name("insured0_name"), insuredName);
        fillField(By.name("insured0_birthDate"), insuredBirthDate);
        fillField(By.name("surname"), surname);
        fillField(By.name("name"), name);
        fillField(By.name("middlename"), middlename);
        fillField(By.name("birthDate"), birthDate);

        driver.findElement(By.name("male")).click();

        fillField(By.name("passport_series"), passportSeries);
        fillField(By.name("passport_number"), passportNumber);
        fillField(By.name("issueDate"), issueDate);
        fillField(By.name("issuePlace"), issuePlace);

        checkFillField(insuredSurname, By.name("insured0_surname"));
        checkFillField(insuredName, By.name("insured0_name"));
        checkFillField(insuredBirthDate, By.name("insured0_birthDate"));
        checkFillField(surname, By.name("surname"));
        checkFillField(name, By.name("name"));
        checkFillField(middlename, By.name("middlename"));
        checkFillField(birthDate, By.name("birthDate"));
        checkFillField(passportSeries, By.name("passport_series"));
        checkFillField(passportNumber, By.name("passport_number"));
        checkFillField(issueDate, By.name("issueDate"));
        checkFillField(issuePlace, By.name("issuePlace"));

        WebElement webElem = driver.findElement(By.xpath("//*[@class='contactsContainer']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElem);
        driver.findElement(By.xpath("//*[text()='Продолжить']")).click();

        assertEquals("Заполнены не все обязательные поля", driver.findElement(
                By.xpath("//div[contains(@ng-show,'tryNext && myForm.$invalid')]")).getText());
    }
}
