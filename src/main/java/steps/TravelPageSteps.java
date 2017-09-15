package steps;

import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelPageSteps {

    @Step("заголовок на странице равен {0}")
    public void checkTitleName(String titleName) {
        new TravelPage().compareTitleName(titleName);
    }

    @Step("выполнено нажатие на кнопку Оформить онлайн")
    public void clickBtn() {
        new TravelPage().issueBtn.click();
    }
}
