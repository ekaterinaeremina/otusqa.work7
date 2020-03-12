package otusqa.pages.registerBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class VKSignInPage extends AbstractPage {

    public VKSignInPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oauth_wrap_content']")
    private WebElement content;

    public WebElement getContent() { return content; }
}
