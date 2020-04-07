package otusqa.steps.registerBy;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.registerBy.VKSignInPage;
import otusqa.steps.AbstractSteps;

public class VKSignInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(VKSignInSteps.class);
    private VKSignInPage vkSignInPage;

    public VKSignInSteps(WebDriver driver) {
        super(driver);
        vkSignInPage = new VKSignInPage(driver);
    }
    @Step ("Загрузка страницы регистрации через Вконтакте")
    public VKSignInSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(vkSignInPage.getContent()));
        log.info("VK page loaded");
        return this;
    }
}
