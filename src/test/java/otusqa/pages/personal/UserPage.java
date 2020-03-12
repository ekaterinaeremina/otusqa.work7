package otusqa.pages.personal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

import java.util.List;

public class UserPage extends AbstractPage {

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//h1[@class='user-info__name'])")
    private WebElement userName;
    @FindBy(xpath = "(//button[contains(@class, 'btn_subscribe')])")
    private WebElement subscribeButton;
    @FindBy(xpath = "(//a[@title='Количество подписчиков'])")
    private WebElement subscriberButton;
    @FindBy(xpath = "//ul[@id='peoples']")
    private WebElement subscriberTable;
    @FindBy(xpath = "(//div[@class='media-obj__body media-obj__body_user-info']/a[2]/div)")
    private WebElement rating;
    @FindBy(xpath = "(//div[@class='media-obj__body media-obj__body_user-info']/a[1]/div)")
    private WebElement karma;
    @FindBy(xpath = "(//a[@class='list-snippet__fullname'])")
    private List<WebElement> subscribers;

    public WebElement getUserName() {return userName; }

    public WebElement getSubscribeButton() { return subscribeButton; }

    public WebElement getSubscriberButton() { return subscriberButton; }

    public WebElement getSubscriberTable() {return subscriberTable; }

    public List<WebElement> getSubscribers() { return subscribers; }

    public WebElement getRating() {return rating; }

    public WebElement getKarma() {return karma; }
}
