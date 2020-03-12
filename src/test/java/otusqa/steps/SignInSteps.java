package otusqa.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.*;

public class SignInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(SignInSteps.class);
    private SignInPage signInPage;

    public SignInSteps(WebDriver driver) {
        super(driver);
        signInPage = new SignInPage(driver);
    }

    public SignInSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(signInPage.getEnterButton()));
        log.info("Sign In page loaded");
        return this;
    }

    private void setEmail(String email)
    {
        inputValue(signInPage.getEmailInput(), email);
    }

    private void setPassword(String pass)
    {
        inputValue(signInPage.getPasswordInput(), pass);
    }

    private void clickEnter() { signInPage.getEnterButton().click(); }

    public MainSteps signIn(String email, String password)
    {
        setEmail(email);
        setPassword(password);
        clickEnter();
        log.info("Click Войти");
        MainSteps mainSteps = new MainSteps(driver).waitLoading();
        log.info("SignIn success");
        return mainSteps;
    }
}
