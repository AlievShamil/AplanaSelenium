import org.junit.Test;
import pages.scenario_1.MainPage;

public class Scenario_1_RefactoringTest extends BaseTest{
    @Test
    public void testInsurance() throws Exception {
       driver.get(baseUrl+"ru/person");

        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegion("Нижегородская область");
        mainPage.checkRegion("Нижегородская область");
        mainPage.scrollToFooter();

        mainPage.checkSocialNetworkIcon(mainPage.facebook);
//        mainPage.checkSocialNetworkIcon(mainPage.twitter);
//        mainPage.checkSocialNetworkIcon(mainPage.youtube);
//        mainPage.checkSocialNetworkIcon(mainPage.instagram);
//        mainPage.checkSocialNetworkIcon(mainPage.vkontakte);
//        mainPage.checkSocialNetworkIcon(mainPage.odnoklassniki);

        Thread.sleep(5000);
    }
}
