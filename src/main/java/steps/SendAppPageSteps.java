package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SendAppPageSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SendAppPage().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("выполнено нажатие на кнопку Продолжить")
    public void clickContinue() {
        new SendAppPage().scrollViewAndClick();
    }

    @Step("появилось сообщение - {0}")
    public void checkErrorMessage(String errMessage) {
        new SendAppPage().checkFieldErrorMessage(errMessage);
    }
}
