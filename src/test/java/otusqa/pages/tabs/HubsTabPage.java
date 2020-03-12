package otusqa.pages.tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class HubsTabPage extends AbstractPage {

    public HubsTabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@id='hubs_suggest'])")
    private WebElement searchField;

    @FindBy(xpath = "(//div[@class='search-field search-field_suggest filled'])")
    private WebElement searchFieldFilled;

    @FindBy(xpath = "(//ul[@id='hubs'])")
    private WebElement table;

    public WebElement getSearchField() { return searchField; }

    public WebElement getSearchFieldFilled() { return searchFieldFilled; }

    public WebElement getTable() { return table; }
}
