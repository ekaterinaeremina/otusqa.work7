package otusqa.steps.personal;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.AbstractPage;
import otusqa.pages.personal.CompanyPage;
import otusqa.steps.AbstractSteps;

public class CompanySteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(CompanySteps.class);
    private CompanyPage companyPage;

    public CompanySteps(WebDriver driver) {
        super(driver);
        companyPage = new CompanyPage(driver);
    }

    public CompanySteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(companyPage.getTitle()));
        log.info("Company page loaded");
        return this;
    }

    public String getCompanyName()
    {
        String name = companyPage.getTitle().getText();
        log.info("Company name is "+ name);
        return name;
    }

    public boolean isSubscribed()
    {
        String state = companyPage.getSubscribeButton().getAttribute("data-state");
        if (state.equals("follow"))
            return false;
        else
            return true;
    }

    public CompanySteps subscribeToCompany()
    {
        if (isSubscribed()) {
            unsubscribeToCompany();
        }
        companyPage.getSubscribeButton().click();
        wait.until(ExpectedConditions.attributeContains(companyPage.getSubscribeButton(), "data-state", "unfollow"));
        log.info("User subscribe to company");
        return this;
    }

    public CompanySteps unsubscribeToCompany()
    {
        if (!isSubscribed()) {
            subscribeToCompany();
        }
        companyPage.getSubscribeButton().click();
        wait.until(ExpectedConditions.attributeContains(companyPage.getSubscribeButton(), "data-state", "follow"));
        log.info("User unsubscribe to company");
        return this;
    }
}
