package otusqa.cases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import otusqa.enums.Tab;
import otusqa.steps.MainSteps;
import otusqa.steps.tabs.PostsTabSteps;

public class PostsTests extends BaseTest {

    private static final Logger log = Logger.getLogger(PostsTests.class);

    @Test
    public void RecomendedPostTitleTest()
    {
        log.info("Start RecomendedPostTitleTest");
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.openMainPage();
        PostsTabSteps postsTabSteps = ((PostsTabSteps) mainSteps.tabsMenuNavigateTo(Tab.Top));

        String titleOnTab = postsTabSteps.getRecomendedPost().get(0);
        String titleOnPostPage = postsTabSteps.goToRecomendedPostByIndex(0).getPostTitle();

        Assert.assertEquals(titleOnTab, titleOnPostPage, "titles not equals");
        log.info("End RecomendedPostTitleTest");
    }
}
