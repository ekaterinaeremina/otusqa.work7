package otusqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.enums.RegistrationMethod;

public class RegistrationPage extends  AbstractPage {

    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='register_form']")
    private WebElement registerForm;

    @FindBy(xpath = "//div[contains(@class, 'socials-buttons')]")
    private WebElement socialsButtons;

    public WebElement getRegisterForm() { return registerForm; }

    public WebElement getSocialsButtons() {return socialsButtons; }

    public WebElement getRegistrationMethodButton(RegistrationMethod method)
    {
        return driver.findElement(By.xpath("(//a[contains(@href,'"+method.getName()+"')])"));
    }
}
