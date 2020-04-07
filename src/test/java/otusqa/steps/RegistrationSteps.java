package otusqa.steps;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.enums.RegistrationMethod;
import otusqa.pages.RegistrationPage;
import otusqa.steps.registerBy.*;

import java.util.Set;

public class RegistrationSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(RegistrationSteps.class);
    private RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver) {
        super(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Step ("Загрузка страницы регистрации")
    public RegistrationSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(registrationPage.getRegisterForm()));
        log.info("Registration page loaded");
        return this;
    }

    @Step ("Загрузка страницы регистрации через {method}")
    public AbstractSteps registerBy(RegistrationMethod method) {
        wait.until(ExpectedConditions.visibilityOf(registrationPage.getSocialsButtons()));
        WebElement el = registrationPage.getRegistrationMethodButton(method);
        el.click();
        log.info("Go to register by " + method.getName());

        switch (method)
        {
            case VK:
                return new VKSignInSteps(driver).waitLoading();
            case Google:
                return new GoogleSignInSteps(driver).waitLoading();
            case Twitter:
                return new TwitterSignInSteps(driver).waitLoading();
            case LiveID:
                return new LiveIdSignInSteps(driver).waitLoading();
            case Github:
                return new GithubSigInSteps(driver).waitLoading();
            case Facebook:
                return new FacebookSignInSteps(driver).waitLoading();
            default:
                return null;
        }
    }
}
