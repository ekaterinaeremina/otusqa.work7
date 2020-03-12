package otusqa.steps.personal;

import org.apache.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import otusqa.pages.personal.PostPage;
import otusqa.steps.AbstractSteps;

public class PostSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(PostSteps.class);
    private PostPage postPage;

    public PostSteps(WebDriver driver) {
        super(driver);
        postPage  = new PostPage(driver);
    }

    public PostSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(postPage.getPostWrapper()));
        log.info("Post page loaded");
        return this;
    }

    public String getPostTitle()
    {
        log.info("Post title: "+ postPage.getPostTitle().getText());
        return postPage.getPostTitle().getText();
    }
}
