package otusqa.steps.registerBy;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.registerBy.LiveIdSignInPage;
import otusqa.steps.AbstractSteps;

public class LiveIdSignInSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(LiveIdSignInSteps.class);
    private LiveIdSignInPage liveIdSignInPage;

    public LiveIdSignInSteps(WebDriver driver) {
        super(driver);
        liveIdSignInPage= new LiveIdSignInPage(driver);
    }

    public LiveIdSignInSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(liveIdSignInPage.getContent()));
        log.info("LiveId pageloaded");
        return this;
    }
}
