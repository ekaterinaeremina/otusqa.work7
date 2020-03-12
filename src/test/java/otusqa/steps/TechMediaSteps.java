package otusqa.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.TechMediaPage;

public class TechMediaSteps extends  AbstractSteps{

    private static final Logger log = Logger.getLogger(TechMediaSteps.class);
    private TechMediaPage techMediaPage;

    public TechMediaSteps(WebDriver driver) {
        super(driver);
        techMediaPage = new TechMediaPage(driver);
    }

    public TechMediaSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(techMediaPage.getServiceCorpblogTitle()));
        log.info("TechMedia page loaded");
        return this;
    }
}
