package otusqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import otusqa.enums.*;

public class MainPage extends AbstractPage {

    public String mainPageRuURL = "https://habr.com/ru/";

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@id='login'])")
    private WebElement loginButton;
    @FindBy(xpath = "(//div[@class='main-navbar']/div[2]/div/button)")
    private WebElement userMenu;
    @FindBy(xpath = "(//a[contains(@href, 'https://habr.com/ru/logout')])")
    private WebElement signOutButton;
    @FindBy(xpath = "//a[contains(@href, 'https://habr.com/ru/auth/register')]")
    private WebElement registrationButton;
    @FindBy(xpath = "(//a[contains(@href, 'https://habr.com/ru/users/')])")
    private WebElement goProfileButton;
    @FindBy(xpath = "(//a[contains(@href, 'https://habr.com/ru/auth/settings/profile/')])")
    private WebElement goProfileSettinsButton;
    @FindBy(xpath = "(//div[@class='tabs']/div[1])")
    private WebElement tabsMenu;
    @FindBy(xpath = "(//div[contains(@class, 'page-header')])")
    private WebElement pageHeader;
    @FindBy(xpath = "//span[@id='dropdown-control']")
    private WebElement showDropdown;

    public WebElement getLoginButton() { return loginButton; }
    public WebElement getRegistrationButton() { return registrationButton; }
    public WebElement getStreamElement(Stream stream) {
        return driver.findElement(By.xpath("(//a[contains(text(), '"+stream.getName()+"')])"));
    }
    public WebElement getUserMenu() { return userMenu; }
    public WebElement getSignOutButton() { return signOutButton; }
    public WebElement getGoProfileButton() {return goProfileButton; }
    public WebElement getGoProfileSettinsButton() { return goProfileSettinsButton; }
    public WebElement getTabsMenu() {return tabsMenu; }
    public WebElement getTabElement(Tab tab) {
        return driver.findElement(By.xpath("//h3[contains(text(),'"+tab.getName()+"')]"));
    }
    public WebElement getContactElement(SocialNetwork network) {
        return driver.findElement(By.xpath("(//a[contains(@class, 'link_"+network.getName()+"')])"));
    }
    public WebElement getPageHeader() { return pageHeader; }
    public WebElement getShowDropdown() { return showDropdown; }
    public WebElement getProjectElement(Project project) {
        return driver.findElement(By.xpath("(//a[contains(@href, '"+project.getName()+"')])"));
    }
}
