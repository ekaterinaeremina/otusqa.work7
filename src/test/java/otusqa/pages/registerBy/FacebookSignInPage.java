package otusqa.pages.registerBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class FacebookSignInPage extends AbstractPage {

    public FacebookSignInPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='login_form_container']")
    private WebElement loginForm;

    public WebElement getLoginForm() { return loginForm; }
}
