package otusqa.pages.personal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class HubPage extends AbstractPage {

    public HubPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//h1[@class='page-header__info-title'])")
    private WebElement title;

    @FindBy(xpath = "(//button[contains(@class, 'btn_subscribe')])")
    private WebElement subscribeButton;

    public WebElement getTitle() {return title; }

    public WebElement getSubscribeButton() { return subscribeButton; }
}
