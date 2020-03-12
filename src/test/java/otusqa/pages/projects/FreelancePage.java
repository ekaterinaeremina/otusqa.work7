package otusqa.pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class FreelancePage extends AbstractPage {

    public FreelancePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='landing-page']")
    private WebElement landing;

    public WebElement getLanding() { return landing; }
}
