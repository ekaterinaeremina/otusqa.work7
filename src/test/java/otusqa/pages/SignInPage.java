package otusqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//input[@id='email_field'])")
    private WebElement emailInput;

    @FindBy(xpath = "(//input[@id='password_field'])")
    private WebElement passwordInput;

    @FindBy(xpath = "(//button[@name='go'])")
    private WebElement enterButton;

    public WebElement getEmailInput() { return emailInput; }

    public WebElement getPasswordInput() { return passwordInput; }

    public WebElement getEnterButton() { return enterButton; }
}
