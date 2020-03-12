package otusqa.steps.tabs;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.tabs.CompaniesTabPage;
import otusqa.steps.AbstractSteps;
import otusqa.steps.TechMediaSteps;
import otusqa.steps.personal.CompanySteps;

import java.util.ArrayList;
import java.util.List;

public class CompaniesTabSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(CompaniesTabSteps.class);
    private CompaniesTabPage companiesTabPage;

    public CompaniesTabSteps(WebDriver driver) {
        super(driver);
        companiesTabPage = new CompaniesTabPage(driver);
    }

    public CompaniesTabSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(companiesTabPage.getSearchField()));
        log.info("CompaniesTab page loaded");
        return this;
    }

    public CompanySteps searchCompanyByName(String name)
    {
        inputValue(companiesTabPage.getSearchField(), name);
        wait.until(ExpectedConditions.visibilityOf(companiesTabPage.getSearchFieldFilled()));
        List<WebElement> results = companiesTabPage.getTable().findElements(By.tagName("li"));
        if (results.size()!=0) {
            log.info("Search succsess");
            String url = results.get(0).findElement(By.tagName("a")).getAttribute("href");
            open(url);
            return new CompanySteps(driver).waitLoading();
        }
        else {
            log.info("No search result");
            return null;
        }
    }

    public CompaniesTabSteps filter(String branch)
    {
        List<WebElement> f = companiesTabPage.getFilters();
        for (int i=0;i<f.size();i++)
        {
            List<WebElement> el = companiesTabPage.getFilterNames();
            if (el.get(i).getText().equals(branch))
            {
                f.get(i).click();
                wait.until(ExpectedConditions.visibilityOf(companiesTabPage.getTable()));
                log.info("filter " + branch + " done");
                return this;
            }
        }
        return this;
    }

    public String getCountCompanyOnFilterMenu(String branch)
    {
        List<WebElement> f = companiesTabPage.getFilters();
        for (int i=0;i<f.size();i++)
        {
            List<WebElement> filters = companiesTabPage.getFilterNames();
            List<WebElement> counters = companiesTabPage.getFilterCounters();
            if (filters.get(i).getText().equals(branch))
            {
                log.info("filter " + branch + " counter: " + counters.get(i).getText());
                return counters.get(i).getText();
            }
        }
        return "";
    }

    private List<String> getCompaniesOnPage()
    {
        if (isElementPresent(companiesTabPage.getTable())) {
            List<WebElement> subscriptions = companiesTabPage.getCompanyNames();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement sub : subscriptions)
                result.add(sub.getText());
            return result;
        }
        else
        {
            return new ArrayList<>();
        }
    }
    public List<String> getCompanies()
    {
        ArrayList<String> result = new ArrayList<String>();
        while(isElementPresent(companiesTabPage.getNextPageButton()))
        {
            result.addAll(getCompaniesOnPage());
            companiesTabPage.getNextPageButton().click();
            wait.until(ExpectedConditions.visibilityOf(companiesTabPage.getTable()));
        }
        result.addAll(getCompaniesOnPage());
        log.info("Find companies: " + result);
        return result;
    }

    public TechMediaSteps addCompany()
    {
        companiesTabPage.getAddCompanyButton().click();
        log.info("Click Добавить компанию");
        return new TechMediaSteps(driver).waitLoading();
    }
}
