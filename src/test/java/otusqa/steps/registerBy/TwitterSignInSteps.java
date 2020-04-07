package otusqa.steps.registerBy;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.registerBy.TwitterSignInPage;
import otusqa.steps.AbstractSteps;

public class TwitterSignInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(TwitterSignInSteps.class);
    private TwitterSignInPage twitterSignInPage;

    public TwitterSignInSteps(WebDriver driver) {
        super(driver);
        twitterSignInPage = new TwitterSignInPage(driver);
    }
    @Step ("Загрузка страницы регистрации через Twitter")
    public TwitterSignInSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(twitterSignInPage.getContent()));
        log.info("Twitter page loaded");
        return this;
    }
}
