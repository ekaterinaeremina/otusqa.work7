package otusqa.steps.registerBy;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.registerBy.FacebookSignInPage;
import otusqa.steps.AbstractSteps;

public class FacebookSignInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(FacebookSignInSteps.class);
    private FacebookSignInPage facebookSignInPage;

    public FacebookSignInSteps(WebDriver driver) {
        super(driver);
        facebookSignInPage = new FacebookSignInPage(driver);
    }
    @Step("Загрузка страницы регистрации через Facebook")
    public FacebookSignInSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(facebookSignInPage.getLoginForm()));
        log.info("Facebook page loaded");
        return this;
    }
}
