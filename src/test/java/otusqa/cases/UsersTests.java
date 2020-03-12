package otusqa.cases;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import otusqa.enums.Tab;
import otusqa.steps.CommonSteps;
import otusqa.steps.MainSteps;
import otusqa.steps.SignInSteps;
import otusqa.steps.personal.UserSteps;
import otusqa.steps.tabs.UsersTabSteps;
import otusqa.testData.UsersTestData;

import java.util.List;

public class UsersTests extends BaseTest {

    private static final Logger log = Logger.getLogger(UsersTests.class);
    private static UsersTestData config = ConfigFactory.create(UsersTestData.class);

    @Test
    public void SubscribeToUserTest() throws Exception {
        log.info("Start SubscribeToUserTest");
        String name = config.nameForSubscribe();
        CommonSteps commonSteps = new CommonSteps(driver);
        MainSteps mainSteps = commonSteps.signIn(login, password);

        UserSteps userSteps = ((UsersTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Users))
                .goToUserPageByName(name)
                .subscribeToUser();

        List<String> subscribers = userSteps.getSubscribers();
        String testUserName = mainSteps.goToProfileUser().getProfileName();
        Assert.assertTrue(subscribers.contains(testUserName), "Subscription not displayed in profile");

        mainSteps.openMainPage();
        userSteps = ((UsersTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Users))
                .goToUserPageByName(name)
                .unsubscribeToUser();

        subscribers = userSteps.getSubscribers();
        Assert.assertTrue(!subscribers.contains(testUserName), "Subscription displayed in profile");
        log.info("End SubscribeToUserTest");
    }

    @Test
    public void displayRatingTest()
    {
        log.info("Start displayRatingTest");
        String name = config.nameForTestdisplay();
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.openMainPage();

        UsersTabSteps usersTabSteps = ((UsersTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Users))
                .searchUserByName(name);

        String ratingOnTab = usersTabSteps.getRatingValue();
        log.info("ratingOnTab = " + ratingOnTab);
        String ratingOnUserPage = usersTabSteps.goToUserPageById(0).getRatingValue();
        log.info("ratingOnUserPage = " + ratingOnUserPage);

        Assert.assertEquals(ratingOnTab, ratingOnUserPage, "Rating not equals");
        log.info("End displayRatingTest");
    }

    @Test
    public void displayKarmaTest()
    {
        log.info("Start displayKarmaTest");
        String name = config.nameForTestdisplay();
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.openMainPage();

        UsersTabSteps usersTabSteps = ((UsersTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Users))
                .searchUserByName(name);

        String karmaOnTab = usersTabSteps.getKarmaValue();
        log.info("karmaOnTab = " + karmaOnTab);
        String karmaOnUserPage = usersTabSteps.goToUserPageById(0).getKarmaValue();
        log.info("karmaOnUserPage = " + karmaOnUserPage);

        Assert.assertEquals(karmaOnTab, karmaOnUserPage, "Karma not equals");
        log.info("End displayKarmaTest");
    }
}
