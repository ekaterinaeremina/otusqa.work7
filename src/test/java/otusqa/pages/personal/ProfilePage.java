package otusqa.pages.personal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

import java.util.List;

public class ProfilePage extends AbstractPage {

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='tabs'])")
    private WebElement tabMenu;
    @FindBy(xpath = "//ul[@id='fan_companies_data_items']")
    private WebElement companiesTable;
    @FindBy(xpath = "//ul[@id='hubs_data_items']")
    private WebElement hubsTable;
    @FindBy(xpath = "(//a[contains(@class,'user-info__nickname')])")
    private WebElement profileName;
    @FindBy(xpath = "//span[contains(@title,'Закладки')]")
    private WebElement favoritesTab;
    @FindBy(xpath = "//a[@class='post__title_link']")
    private List<WebElement> favoritesPost;
    @FindBy(xpath = "//a[contains(@href, '/favorites/')]")
    private WebElement publishButton;
    @FindBy(xpath = "(//a[@class='list-snippet__title-link'])")
    List<WebElement> companyNames;
    @FindBy(xpath = "(//a[contains(@class, 'user-hub_cross')])")
    List<WebElement> nubNames;

    public WebElement getTabMenu() {return tabMenu; }
    public WebElement getCompaniesTable() {return companiesTable; }
    public WebElement getHubsTable() {return  hubsTable;}
    public List<WebElement> getCompanyNames() {return companyNames; }
    public List<WebElement> getHubNames() { return nubNames; }
    public WebElement getProfileName() {return profileName; }
    public WebElement getFavoritesTab() { return favoritesTab; }
    public List<WebElement> getFavoritesPost() {return favoritesPost; }
    public WebElement getPublishButton() { return publishButton; }
}
