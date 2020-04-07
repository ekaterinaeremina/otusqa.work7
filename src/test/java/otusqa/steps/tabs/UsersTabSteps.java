package otusqa.steps.tabs;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.tabs.UsersTabPage;
import otusqa.steps.AbstractSteps;
import otusqa.steps.personal.UserSteps;

import java.util.List;

public class UsersTabSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(UsersTabSteps.class);
    private UsersTabPage usersTabPage;

    public UsersTabSteps(WebDriver driver) {
        super(driver);
        usersTabPage  = new UsersTabPage(driver);
    }
    @Step ("Загрузка страницы Авторы")
    public UsersTabSteps waitLoading() {
        wait.until(ExpectedConditions.visibilityOf(usersTabPage.getSearchField()));
        log.info("UserTab page loaded");
        return this;
    }
    @Step ("Поиск автора по имени {name}")
    public UsersTabSteps searchUserByName(String name) {
        inputValue(usersTabPage.getSearchField(), name);
        wait.until(ExpectedConditions.visibilityOf(usersTabPage.getSearchFieldFilled()));
        return this;
    }
    @Step ("Перход на страницу {id}го пользователя в результатах поиска")
    public UserSteps goToUserPageById(int id) {
        List<WebElement> results = usersTabPage.getTable().findElements(By.tagName("li"));
        if (results.size()!=0) {
            log.info("Search succsess");
            String url = results.get(id).findElement(By.tagName("a")).getAttribute("href");
            open(url);
            return new UserSteps(driver).waitLoading();
        }
        else {
            log.info("No search result");
            return null;
        }
    }
    @Step ("Переход на страницу пользователя {name}")
    public UserSteps goToUserPageByName(String name) {
        return searchUserByName(name)
                .goToUserPageById(0);
    }
    @Step ("Получение рейтинга первого пользователя в результатах поиска")
    public String getRatingValue() { return usersTabPage.getRating().getText(); }
    @Step("Получение кармы первого пользователя в результатах поиска")
    public String getKarmaValue()
    {
        return usersTabPage.getKarma().getText();
    }
}
