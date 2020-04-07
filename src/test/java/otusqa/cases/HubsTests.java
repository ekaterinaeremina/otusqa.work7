package otusqa.cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import otusqa.enums.Tab;
import otusqa.steps.CommonSteps;
import otusqa.steps.MainSteps;
import otusqa.steps.SignInSteps;
import otusqa.steps.personal.HubSteps;
import otusqa.steps.tabs.HubsTabSteps;
import otusqa.testData.HubsTestData;

import java.util.List;

public class HubsTests extends BaseTest {

    private static final Logger log = Logger.getLogger(HubsTests.class);
    private static HubsTestData config = ConfigFactory.create(HubsTestData.class);

    @Test
    @Epics(value = {@Epic(value = "Хабы"), @Epic(value = "Избранное")})
    @Description("Тест на проверку подписки пользователя на хаб")
    public void SubscribeToHubTest() throws Exception {
        log.info("Start SubscribeToHubTest");
        String hubName = config.hubName();
        CommonSteps commonSteps = new CommonSteps(driver);
        MainSteps mainSteps = commonSteps.signIn(login, password);

        HubSteps hubSteps = ((HubsTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Hubs))
                .searchHubByName(hubName)
                .subscribeToHub();

        String name = hubSteps.getHubName();
        List<String> subscriptions = mainSteps.goToProfileUser().getHubs();
        Assert.assertTrue(subscriptions.contains(name), "Subscription not displayed in profile");

        mainSteps.openMainPage();
        ((HubsTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Hubs))
                .searchHubByName(hubName)
                .unsubscribeToHub();

        subscriptions = mainSteps.goToProfileUser().getHubs();
        Assert.assertTrue(!subscriptions.contains(name), "Subscription displayed in profile");
        log.info("End SubscribeToHubTest");
    }
}
