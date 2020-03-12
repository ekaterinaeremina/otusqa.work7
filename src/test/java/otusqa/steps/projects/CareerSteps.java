package otusqa.steps.projects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.projects.CareerPage;
import otusqa.steps.AbstractSteps;

public class CareerSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(CareerSteps.class);
    private CareerPage careerPage;

    public CareerSteps(WebDriver driver) {
        super(driver);
        careerPage = new CareerPage(driver);
    }

    public CareerSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(careerPage.getContent()));
        log.info("Career page loaded");
        return this;
    }
}
