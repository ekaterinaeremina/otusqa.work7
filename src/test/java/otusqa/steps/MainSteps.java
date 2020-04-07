package otusqa.steps;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import otusqa.enums.*;
import otusqa.pages.*;
import otusqa.steps.personal.*;
import otusqa.steps.projects.*;
import otusqa.steps.settings.*;
import otusqa.steps.tabs.*;

import java.util.List;

public class MainSteps extends AbstractSteps{

    private static final Logger log = Logger.getLogger(MainSteps.class);
    public MainPage mainPage;

    public MainSteps(WebDriver driver) {
        super(driver);
        mainPage = new MainPage(driver);
    }
    @Step("Открытие главой страницы")
    public MainSteps openMainPage() {
        super.open(mainPage.mainPageRuURL);
        return waitLoading();
    }

    @Step ("Загрузка главной страницы")
    public MainSteps waitLoading() {
        wait.until(ExpectedConditions.visibilityOf(mainPage.getTabsMenu()));
        log.info("Main page loaded");
        return this;
    }

    @Step ("Переход на страницу авторизации")
    public SignInSteps goToSignIn() {
        mainPage.getLoginButton().click();
        log.info("Click Войти");
        return new SignInSteps(driver).waitLoading();
    }

    @Step ("Переход на страницу регистрации")
    public RegistrationSteps goToRegistration() {
        mainPage.getRegistrationButton().click();
        log.info("Click Регистрация");
        return new RegistrationSteps(driver).waitLoading();
    }

    @Step ("Проверка, что пользователь авторизован")
    public boolean isSignIn() { return isElementPresent(mainPage.getUserMenu()); }

    @Step ("Выход из учетной записи")
    public MainSteps signOut() throws Exception {
        if (!isSignIn())
            throw new Exception("There is not signIn");
        goToTabInUserMenu(mainPage.getSignOutButton());
        log.info("Click Выйти");
        waitLoading();
        log.info("SignOut Success");
        return this;
    }

    @Step ("Переход на {tab} в пользовательском меню")
    private void goToTabInUserMenu(WebElement tab) {
        mainPage.getUserMenu().click();
        wait.until(ExpectedConditions.visibilityOf(tab));
        log.info("Open user menu");
        tab.click();
    }

    @Step ("Переход в настройки профиля")
    public ProfileSettingsSteps goToProfileSettings()
    {
        goToTabInUserMenu(mainPage.getGoProfileSettinsButton());
        log.info("Click Настройки");
        return new ProfileSettingsSteps(driver).waitLoading();
    }

    @Step ("Переход на страницу профиля")
    public ProfileSteps goToProfileUser() {
        goToTabInUserMenu(mainPage.getGoProfileButton());
        log.info("Click Профиль");
        return new ProfileSteps(driver).waitLoading();
    }

    @Step ("Переход на вкладку {tab}")
    public AbstractSteps tabsMenuNavigateTo(Tab tab) {
        wait.until(ExpectedConditions.visibilityOf(mainPage.getTabElement(tab)));
        mainPage.getTabElement(tab).click();
        log.info("Go to tab: " +tab.getName());
        switch (tab)
        {
            case Companies:
                return new CompaniesTabSteps(driver).waitLoading();
            case Users:
                return new UsersTabSteps(driver).waitLoading();
            case Hubs:
                return new HubsTabSteps(driver).waitLoading();
            case Top:
                return new PostsTabSteps(driver).waitLoading();
            case News:
                return new PostsTabSteps(driver).waitLoading();
            default:
                return null;
        }
    }

    @Step ("Открытие страницы в {network}")
    public void openSocialNetworkPage(SocialNetwork network) {
        wait.until(ExpectedConditions.visibilityOf(mainPage.getContactElement(network)));
        WebElement el = mainPage.getContactElement(network);
        el.click();
        log.info("Go to " + el.getAttribute("href"));
    }

    @Step ("Переход на поток {stream}")
    public MainSteps navigateToStream(Stream stream) {
        mainPage.getStreamElement(stream).click();
        waitLoading();
        log.info("Go to "+ stream.getName());
        return this;
    }

    @Step ("Получение заголовка главной страницы")
    public String getPageHeader() { return mainPage.getPageHeader().getText(); }

    @Step ("Открытие страницы {project}")
    public AbstractSteps openProjectPage(Project project) {
        mainPage.getShowDropdown().click();
        wait.until(ExpectedConditions.visibilityOf(mainPage.getProjectElement(project)));
        mainPage.getProjectElement(project).click();
        log.info("Go to project  "+project.getName() + ": " + project.getUrl());
        switch (project)
        {
            case Hubr:
                return this.waitLoading();
            case QnA:
                return new QnASteps(driver).waitLoading();
            case Career:
                return new CareerSteps(driver).waitLoading();
            case Freelance:
                return new FreelanceSteps(driver).waitLoading();
            default:
                return null;
        }
    }
}
