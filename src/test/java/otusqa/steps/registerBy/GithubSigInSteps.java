package otusqa.steps.registerBy;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.registerBy.GithubSigInPage;
import otusqa.steps.AbstractSteps;

public class GithubSigInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(GithubSigInSteps.class);
    private GithubSigInPage githubSigInPage;

    public GithubSigInSteps(WebDriver driver) {
        super(driver);
        githubSigInPage = new GithubSigInPage(driver);
    }
    @Step("Загрузка страницы регистрации через Github")
    public GithubSigInSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(githubSigInPage.getContent()));
        log.info("Github page loaded");
        return this;
    }
}
