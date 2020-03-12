package otusqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechMediaPage extends  AbstractPage {

    public TechMediaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='service-corpblog-title']")
    private WebElement serviceCorpblogTitle;

    public WebElement getServiceCorpblogTitle() { return serviceCorpblogTitle; }

}
