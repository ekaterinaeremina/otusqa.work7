package otusqa.pages.tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import otusqa.pages.AbstractPage;

import java.util.List;

public class PostsTabPage extends AbstractPage {

    public PostsTabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='posts_list']")
    private WebElement postContainer;

    @FindBy(xpath = "//a[@class='post-info__title']")
    private List<WebElement> recomendedPosts;

    @FindBy(xpath = "//span[@class='news-topic__attr news-topic__attr_date-time']")
    private List<WebElement> newsTime;

    public WebElement getPostContainer() { return postContainer; }

    public List<WebElement> getRecomendedPosts() { return recomendedPosts; }
    
    public List<WebElement> getNewsTime() {return newsTime; }
    



}
