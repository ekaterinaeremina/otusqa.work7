package otusqa.steps.registerBy;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.helpers.WindowsHelper;
import otusqa.pages.registerBy.GoogleSignInPage;
import otusqa.steps.AbstractSteps;

import java.util.Set;

public class GoogleSignInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(GoogleSignInSteps.class);
    private GoogleSignInPage googleSignInPage;

    public GoogleSignInSteps(WebDriver driver) {
        super(driver);
        googleSignInPage = new GoogleSignInPage(driver);
    }
    @Step ("Загрузка страницы регистрации через Google")
    public GoogleSignInSteps waitLoading()
    {
        WindowsHelper.switchToLastWindow(driver);
        wait.until(ExpectedConditions.visibilityOf(googleSignInPage.getContent()));
        log.info("Google page loaded");
        return this;
    }
}
