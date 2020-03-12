package otusqa.cases;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import otusqa.enums.*;
import otusqa.helpers.WindowsHelper;
import otusqa.steps.MainSteps;
import otusqa.steps.RegistrationSteps;
import otusqa.steps.TechMediaSteps;
import otusqa.steps.tabs.CompaniesTabSteps;
import otusqa.testData.CompaniesTestData;

import java.util.Set;

public class LinksTests extends BaseTest {

    private static final Logger log = Logger.getLogger(LinksTests.class);
    private static CompaniesTestData config = ConfigFactory.create(CompaniesTestData.class);

    @Test
    public void SocialNetworkLinksTest() {
        log.info("Start SocialNetworkLinksTest");
        SoftAssert softAssert = new SoftAssert();
        MainSteps mainSteps = new MainSteps(driver).openMainPage();

        for (int i = 1; i<= SocialNetwork.values().length-1; i++) {
            mainSteps.openSocialNetworkPage(SocialNetwork.values()[i]);
            selectBrowserTab(i);
            softAssert.assertEquals(driver.getCurrentUrl(), SocialNetwork.values()[i].getUrl());
            selectBrowserTab(0);
        }

        softAssert.assertAll();
        log.info("End SocialNetworkLinksTest");
    }

    @Test
    public void ProjectLinksTest() {
        log.info("Start ProjectLinksTest");
        SoftAssert softAssert = new SoftAssert();
        MainSteps mainSteps = new MainSteps(driver).openMainPage();

        for (int i = 0; i<= Project.values().length-1; i++) {
            mainSteps.openProjectPage(Project.values()[i]);
            softAssert.assertTrue(driver.getCurrentUrl().contains(Project.values()[i].getUrl()));
            mainSteps.openMainPage();
        }

        softAssert.assertAll();
        log.info("End ProjectLinksTest");
    }

    @Test
    public void StreamLinksTest() {
        log.info("Start StreamLinksTest");
        SoftAssert softAssert = new SoftAssert();
        MainSteps mainSteps = new MainSteps(driver).openMainPage();

        for (int i = 1; i<= Stream.values().length-1; i++) {
            mainSteps.navigateToStream(Stream.values()[i]);
            softAssert.assertEquals(driver.getCurrentUrl(), Stream.values()[i].getUrl());
            softAssert.assertEquals(mainSteps.getPageHeader(), Stream.values()[i].getName());
        }

        softAssert.assertAll();
        log.info("End StreamLinksTest");
    }

    @Test
    public void TabMenuLinksTest()
    {
        log.info("Start TabMenuLinksTest");
        SoftAssert softAssert = new SoftAssert();
        MainSteps mainSteps = new MainSteps(driver).openMainPage();

        for (int i = 1; i<= Tab.values().length-1; i++) {
            mainSteps.tabsMenuNavigateTo(Tab.values()[i]);
            softAssert.assertEquals(driver.getCurrentUrl(), Tab.values()[i].getUrl());
        }

        softAssert.assertAll();
        log.info("End TabMenuLinksTest");
    }

    @Test
    public void RegisterByLinksTest() {
        log.info("Start RegisterByLinksTest");
        SoftAssert softAssert = new SoftAssert();
        RegistrationSteps registrationSteps = new MainSteps(driver).openMainPage().goToRegistration();

        for (int i = 1; i<= RegistrationMethod.values().length-1; i++) {
            registrationSteps.registerBy(RegistrationMethod.values()[i]);
            String actual = driver.getCurrentUrl();
            String excepted = RegistrationMethod.values()[i].getUrl();
            softAssert.assertTrue(actual.contains(excepted), "link  for " + RegistrationMethod.values()[i].getName() + " not correct");

            if (RegistrationMethod.values()[i].getName()=="#") {
                driver.close();
                WindowsHelper.switchToLastWindow(driver);
            }
            else { driver.navigate().back(); }
        }

        softAssert.assertAll();
        log.info("End RegisterByLinksTest");
    }

    @Test
    public void AddCompanyLinkTest()
    {
        log.info("Start AddCompanyTest");
        String techMediaURL = config.techMediaURL();
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.openMainPage();

        TechMediaSteps techMediaSteps = ((CompaniesTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Companies))
                .addCompany();

        Assert.assertEquals(driver.getCurrentUrl(), techMediaURL);
        log.info("End AddCompanyTest");
    }
}
