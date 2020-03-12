package otusqa.pages.personal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

public class PostPage extends AbstractPage {

    public PostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='post__wrapper']")
    private WebElement postWrapper;
    @FindBy(xpath = "//span[@class='post__title-text']")
    private WebElement postTitle;

    public WebElement getPostWrapper() { return postWrapper; }
    public WebElement getPostTitle() { return postTitle; }


}
