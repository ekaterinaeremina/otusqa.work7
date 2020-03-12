package otusqa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class ProfileSettingsPage extends AbstractPage {

    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='h-page__title']")
    private WebElement header;

    @FindBy(xpath = "//input[@class='h-form-input__control']")
    private WebElement realName;

    public WebElement getHeader() { return header; }

    public WebElement getRealName() { return realName; }
}
