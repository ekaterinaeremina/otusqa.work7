package otusqa.pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class CareerPage extends AbstractPage {

    public CareerPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='content']")
    private WebElement content;

    public WebElement getContent() { return content; }
}
