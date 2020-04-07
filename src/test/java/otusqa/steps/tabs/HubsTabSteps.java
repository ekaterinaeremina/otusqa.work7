package otusqa.steps.tabs;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.tabs.HubsTabPage;
import otusqa.steps.AbstractSteps;
import otusqa.steps.personal.HubSteps;

import java.util.List;

public class HubsTabSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(HubsTabSteps.class);
    private HubsTabPage hubsTabPage;

    public HubsTabSteps(WebDriver driver) {
        super(driver);
        hubsTabPage = new HubsTabPage(driver);
    }
    @Step ("Загрузка страницы Хабы")
    public HubsTabSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(hubsTabPage.getSearchField()));
        log.info("HubTab page loaded");
        return this;
    }

    @Step ("Поиск хаба по названию {name}")
    public HubSteps searchHubByName(String name)
    {
        inputValue(hubsTabPage.getSearchField(), name);
        wait.until(ExpectedConditions.visibilityOf(hubsTabPage.getSearchFieldFilled()));
        List<WebElement> results = hubsTabPage.getTable().findElements(By.tagName("li"));
        if (results.size()!=0) {
            log.info("Search succsess");
            String url = results.get(0).findElement(By.tagName("a")).getAttribute("href");
            open(url);
            return new HubSteps(driver).waitLoading();
        }
        else {
            log.info("No search result");
            return null;
        }
    }
}
