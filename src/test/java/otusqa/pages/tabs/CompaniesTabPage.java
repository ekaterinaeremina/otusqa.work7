package otusqa.pages.tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

import java.util.List;

public class CompaniesTabPage extends AbstractPage {

    public CompaniesTabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@id='companies_suggest'])")
    private WebElement searchField;
    @FindBy(xpath = "(//div[@class='search-field search-field_suggest filled'])")
    private WebElement searchFieldFilled;
    @FindBy(xpath = "(//ul[@id='companies'])")
    private WebElement table;
    @FindBy(xpath = "//li[contains(@class,'item_devided')]")
    private List<WebElement> filters;
    @FindBy(xpath = "//span[@class='stacked-menu__item-text']")
    private List<WebElement> filterNames;
    @FindBy(xpath = "//span[contains(@class,'stacked-menu__item-counter')]")
    private List<WebElement> filterCounters;
    @FindBy(xpath = "(//a[@class='list-snippet__title-link'])")
    private List<WebElement> companyNames;
    @FindBy(xpath = "//ul[@class='stacked-menu']")
    private WebElement filtersTable;
    @FindBy(xpath = "//a[@id='next_page']")
    private WebElement nextPageButton;
    @FindBy(xpath = "//a[text()='Добавить компанию']")
    private WebElement addCompanyButton;

    public WebElement getSearchField() { return searchField; }
    public WebElement getSearchFieldFilled() { return searchFieldFilled; }
    public WebElement getTable() { return table; }
    public List<WebElement> getCompanyNames() { return companyNames; }
    public List<WebElement> getFilters() { return filters; }
    public List<WebElement> getFilterNames() { return filterNames; }
    public List<WebElement> getFilterCounters() { return filterCounters; }
    public WebElement getNextPageButton() { return nextPageButton; }
    public WebElement getAddCompanyButton(){return addCompanyButton; }
}
