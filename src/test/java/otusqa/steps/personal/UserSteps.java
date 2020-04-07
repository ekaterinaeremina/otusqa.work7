package otusqa.steps.personal;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.personal.UserPage;
import otusqa.steps.AbstractSteps;

import java.util.ArrayList;
import java.util.List;

public class UserSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(UserSteps.class);
    private UserPage userPage;

    public UserSteps(WebDriver driver) {
        super(driver);
        userPage  = new UserPage(driver);
    }
    @Step ("Загрузка страницы автора")
    public UserSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(userPage.getUserName()));
        log.info("User page loaded");
        return this;
    }
    @Step ("Получение имени автора")
    public String getUserName()
    {
        return userPage.getUserName().getText();
    }

    @Step ("Проверка подписан ли пользователь на автора")
    public boolean isSubscribed()
    {
        String state = userPage.getSubscribeButton().getAttribute("data-state");
        if (state.equals("follow"))
            return false;
        else
            return true;
    }
    @Step ("Подписка на автора")
    public UserSteps subscribeToUser()
    {
        userPage.getSubscribeButton().click();
        log.info("Click sub");
        wait.until(ExpectedConditions.attributeContains(userPage.getSubscribeButton(), "data-state", "unfollow"));
        log.info("Subscribe success");
        return this;
    }
    @Step ("Отписка от автора")
    public UserSteps unsubscribeToUser()
    {
        userPage.getSubscribeButton().click();
        log.info("Click sub");
        wait.until(ExpectedConditions.attributeContains(userPage.getSubscribeButton(), "data-state", "follow"));
        log.info("Unsubscribe success");
        return this;
    }

    @Step ("Получение подписчиков автора")
    public List<String> getSubscribers() {
        userPage.getSubscriberButton().click();
        if (isElementPresent(userPage.getSubscriberTable())) {
            wait.until(ExpectedConditions.visibilityOf(userPage.getSubscriberTable()));
            List<WebElement> subscribers = userPage.getSubscribers();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement sub : subscribers)
                result.add(sub.getText());
            log.info("Find Subscribers: " + result);
            return result;
        }
        else {
            log.info("Not found Subscribers");
            return new ArrayList<>();
        }
    }

    @Step ("Получение рейтинга автора")
    public String getRatingValue()
    {
        return userPage.getRating().getText();
    }
    @Step ("Получение кармы автора")
    public String getKarmaValue()
    {
        return userPage.getKarma().getText();
    }
}
