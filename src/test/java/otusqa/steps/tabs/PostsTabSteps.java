package otusqa.steps.tabs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.tabs.PostsTabPage;
import otusqa.steps.AbstractSteps;
import otusqa.steps.personal.PostSteps;

import java.util.ArrayList;
import java.util.List;

public class PostsTabSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(UsersTabSteps.class);
    private PostsTabPage postsTabPage;

    public PostsTabSteps(WebDriver driver) {
        super(driver);
        postsTabPage = new PostsTabPage(driver);
    }

    public PostsTabSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(postsTabPage.getPostContainer()));
        log.info("PostsTab page loaded");
        return this;
    }

    public PostSteps goToRecomendedPostByIndex(int index)
    {
        postsTabPage.getRecomendedPosts().get(index).click();
        log.info("Go to " + index + " post in recomended");
        return new PostSteps(driver).waitLoading();
    }

    public List<String> getRecomendedPost()
    {
        ArrayList<String> result = new ArrayList<>();
        for (WebElement el : postsTabPage.getRecomendedPosts())
            result.add(el.getText());
        log.info("Recomended post: "+ result);
        return result;
    }

    public List<String> getNewsTime()
    {
        ArrayList<String> result = new ArrayList<>();
        for (WebElement el : postsTabPage.getNewsTime())
            result.add(el.getText());
        log.info("News time on page: "+ result);
        return result;
    }
}
