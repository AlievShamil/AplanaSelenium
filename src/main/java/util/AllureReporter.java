package util;

import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;

import static steps.BaseSteps.getDriver;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) takeScreenshots(result);
        super.result(result);
    }

    public void takeScreenshots(Result step) {
        if (getDriver() != null) {
            Allure.LIFECYCLE.fire(new MakeAttachmentEvent(
                    ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES),
                    "Скриншот в момент ошибки", "image/png"));
        }
    }
}
