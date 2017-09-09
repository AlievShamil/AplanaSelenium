import org.junit.Test;
import pages.MainPage;
import pages.PolicyPage;
import pages.SendAppPage;
import pages.TravelPage;

import static org.junit.Assert.assertEquals;

public class RefactoringTest extends BaseTest {

    @Test
    public void testIcons() throws Exception {
        driver.get(baseUrl + "ru/person");

        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegion("Нижегородская область");
        mainPage.checkRegion("Нижегородская область");
        mainPage.scrollToFooter();

        mainPage.checkSocialNetworkIcon(mainPage.facebook);
        mainPage.checkSocialNetworkIcon(mainPage.twitter);
        mainPage.checkSocialNetworkIcon(mainPage.youtube);
        mainPage.checkSocialNetworkIcon(mainPage.instagram);
        mainPage.checkSocialNetworkIcon(mainPage.vkontakte);
        mainPage.checkSocialNetworkIcon(mainPage.odnoklassniki);
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "ru/person");

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Застраховать себя");
        mainPage.selectInsuranceItem("Страхование путешественников");

        TravelPage travelPage = new TravelPage(driver);
        travelPage.clickIssueBtn();
        assertEquals("«Сбербанк» - Страхование путешественников", travelPage.getTitle());

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        PolicyPage policyPage = new PolicyPage(driver);
        policyPage.checkAmountOfCoverage("Минимальная");
        policyPage.clickIssueBtn();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Surname", "Medvedev");
        sendAppPage.fillField("Name", "Dmitry");
        sendAppPage.fillField("Birth Date", "01.01.1991");
        sendAppPage.fillField("Фамилия", "Путин");
        sendAppPage.fillField("Имя", "Владимир");
        sendAppPage.fillField("Отчество", "Владимирович");
        sendAppPage.fillField("Дата рождения", "02.02.1992");
        sendAppPage.checkSex("Муж");
        sendAppPage.fillField("Серия паспорта", "1111");
        sendAppPage.fillField("Номер паспорта", "222222");
        sendAppPage.fillField("Дата выдачи", "07.07.2017");
        sendAppPage.fillField("Кем выдан", "он вам не Димон");

        sendAppPage.scrollViewAndClick();

        sendAppPage.checkFillField("Medvedev", sendAppPage.insuredSurname);
        sendAppPage.checkFillField("Dmitry", sendAppPage.insuredName);
        sendAppPage.checkFillField("01.01.1991", sendAppPage.insuredBirthDate);
        sendAppPage.checkFillField("Путин", sendAppPage.surname);
        sendAppPage.checkFillField("Владимир", sendAppPage.name);
        sendAppPage.checkFillField("Владимирович", sendAppPage.middlename);
        sendAppPage.checkFillField("02.02.1992", sendAppPage.birthDate);
        sendAppPage.checkFillField("1111", sendAppPage.passportSeries);
        sendAppPage.checkFillField("222222", sendAppPage.passportNumber);
        sendAppPage.checkFillField("07.07.2017", sendAppPage.issueDate);
        sendAppPage.checkFillField("он вам не Димон", sendAppPage.issuePlace);

        sendAppPage.checkFieldErrorMessage("Заполнены не все обязательные поля");
    }
}
