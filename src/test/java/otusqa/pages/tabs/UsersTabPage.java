package otusqa.pages.tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class UsersTabPage extends AbstractPage {

    public UsersTabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@id='people_suggest'])")
    private WebElement searchField;
    @FindBy(xpath = "(//div[@class='search-field search-field_suggest filled'])")
    private WebElement searchFieldFilled;
    @FindBy(xpath = "(//ul[@id='peoples'])")
    private WebElement table;
    @FindBy(xpath = "(//div[@title='Рейтинг'])")
    private WebElement rating;
    @FindBy(xpath = "(//div[@title='Карма'])")
    private WebElement karma;

    public WebElement getSearchField() { return searchField; }
    public WebElement getSearchFieldFilled() { return searchFieldFilled; }
    public WebElement getTable() { return table; }
    public WebElement getRating() { return rating; }
    public WebElement getKarma() { return karma; }

}
