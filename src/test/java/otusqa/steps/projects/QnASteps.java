package otusqa.steps.projects;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.projects.QnAPage;
import otusqa.steps.AbstractSteps;

public class QnASteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(QnASteps.class);
    private QnAPage qnAPage;

    public QnASteps(WebDriver driver) {
        super(driver);
        qnAPage = new QnAPage(driver);
    }
    @Step ("Загрузка страницы Q&A")
    public QnASteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(qnAPage.getPage()));
        log.info("QnA page loaded");
        return this;
    }
}
