package otusqa.steps.projects;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.projects.FreelancePage;
import otusqa.steps.AbstractSteps;

public class FreelanceSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(FreelanceSteps.class);
    private FreelancePage freelancePage;

    public FreelanceSteps(WebDriver driver) {
        super(driver);
        freelancePage = new FreelancePage(driver);
    }
    @Step ("Загрузка страницы Фриланс")
    public FreelanceSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(freelancePage.getLanding()));
        log.info("Freelance page loaded");
        return this;
    }
}
