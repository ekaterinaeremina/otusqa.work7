package otusqa.cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import otusqa.enums.Tab;
import otusqa.testData.CompaniesTestData;
import otusqa.steps.CommonSteps;
import otusqa.steps.MainSteps;
import otusqa.steps.personal.CompanySteps;
import otusqa.steps.tabs.CompaniesTabSteps;

import java.util.List;

public class CompaniesTests extends BaseTest {

    private static final Logger log = Logger.getLogger(CompaniesTests.class);
    private static CompaniesTestData config = ConfigFactory.create(CompaniesTestData.class);

    @Test
    @Epics(value = {@Epic(value = "Компании"), @Epic(value = "Избранное")})
    @Description("Тест на проверку подписки пользователя на компанию")
    public void SubscribeToCompanyTest() throws Exception {
        log.info("Start SubscribeToCompanyTest");
        String companyName=config.companyName();
        CommonSteps commonSteps = new CommonSteps(driver);
        MainSteps mainSteps = commonSteps.signIn(login, password);

        CompanySteps companySteps = ((CompaniesTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Companies))
                .searchCompanyByName(companyName)
                .subscribeToCompany();


        String name = companySteps.getCompanyName();
        List<String> subscriptions = mainSteps.goToProfileUser().getCompanies();
        Assert.assertTrue(subscriptions.contains(name), "Subscription not displayed in profile");

        mainSteps.openMainPage();
        ((CompaniesTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Companies))
                .searchCompanyByName(companyName)
                .unsubscribeToCompany();

        subscriptions = mainSteps.goToProfileUser().getCompanies();
        Assert.assertTrue(!subscriptions.contains(name), "Subscription displayed in profile");

        log.info("End SubscribeToCompanyTest");
    }

    @Test
    @Epics(value = {@Epic(value = "Компании"), @Epic(value = "Отображение данных")})
    @Description("Тест на проверку отображения количества компаний для фильтра")
    public void CheckCompanyCounterAfterFilterTest()
    {
        log.info("Start CheckCompanyCounterAfterFilterTest");
        String filterName=config.filterName();
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.openMainPage();

        CompaniesTabSteps companiesTabSteps = ((CompaniesTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Companies))
                .filter(filterName);

        String countCompanyOnFilterMenu = companiesTabSteps.getCountCompanyOnFilterMenu(filterName);
        int countOnTable = companiesTabSteps.getCompanies().size();

        Assert.assertEquals(Integer.parseInt(countCompanyOnFilterMenu),countOnTable, "Count companies not equals");

        log.info("End CheckCompanyCounterAfterFilterTest");
    }

}
