package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {

    MainPage mainPage = new MainPage();

    @Step("выполнено нажатие на кнопку выбора регион")
    public void clickRegion(){
        mainPage.menuRegion.click();
    }

    @Step("выбран региона {0}")
    public void chooseRegion(String regionName) {
        mainPage.selectRegion(regionName);
    }

    @Step("регион на главной странице равен - {0}")
    public void checkRegion(String regionName) {
        mainPage.checkRegion(regionName);
    }

    @Step("выполнен скролл до footer объекта")
    public void scrollPage() {
        mainPage.scrollToFooter();
    }

    @Step("выполненна проверка соц. сетей")
    public void checkElements(){
        mainPage.checkElements();
    }

    @Step("выполнено нажатие на {0}")
    public void clickMenuItem(String menuName) {
       mainPage.selectMenuItem(menuName);
    }

    @Step("выполнено нажатие на {0}")
    public void selectInsuranceMenu(String menuName) {
        mainPage.selectInsuranceItem(menuName);
    }
}
