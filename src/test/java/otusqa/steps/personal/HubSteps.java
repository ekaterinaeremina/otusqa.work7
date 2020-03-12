package otusqa.steps.personal;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.personal.HubPage;
import otusqa.steps.AbstractSteps;

public class HubSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(HubSteps.class);
    private HubPage hubPage;

    public HubSteps(WebDriver driver) {
        super(driver);
        hubPage = new HubPage(driver);
    }

    public HubSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(hubPage.getTitle()));
        log.info("Hub page loaded");
        return this;
    }

    public String getHubName()
    {
        return hubPage.getTitle().getText();
    }

    public boolean isSubscribed()
    {
        String state = hubPage.getSubscribeButton().getAttribute("data-state");
        if (state.equals("follow"))
            return false;
        else
            return true;
    }

    public HubSteps subscribeToHub()
    {
        if (isSubscribed()) {
            unsubscribeToHub();
        }
        hubPage.getSubscribeButton().click();
        wait.until(ExpectedConditions.attributeContains(hubPage.getSubscribeButton(), "data-state", "unfollow"));
        log.info("User subscribe to hub");
        return this;
    }

    public HubSteps unsubscribeToHub()
    {
        if (!isSubscribed()) {
            subscribeToHub();
        }
        hubPage.getSubscribeButton().click();
        wait.until(ExpectedConditions.attributeContains(hubPage.getSubscribeButton(), "data-state", "follow"));
        log.info("User unsubscribe to hub");
        return this;
    }
}
