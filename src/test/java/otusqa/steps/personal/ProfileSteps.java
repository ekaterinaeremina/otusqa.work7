package otusqa.steps.personal;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.personal.ProfilePage;
import otusqa.steps.AbstractSteps;

import java.util.ArrayList;
import java.util.List;

public class ProfileSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(ProfileSteps.class);
    private ProfilePage profilePage ;

    public ProfileSteps(WebDriver driver) {
        super(driver);
        profilePage = new ProfilePage(driver);
    }

    public ProfileSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(profilePage.getTabMenu()));
        log.info("Profile page loaded");
        return this;
    }

    public ArrayList<String> getCompanies()
    {
        if (isElementPresent(profilePage.getCompaniesTable())) {
            List<WebElement> subscriptions = profilePage.getCompanyNames();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement sub : subscriptions)
                result.add(sub.getText());
            log.info("Find favorite companies: " + result);
            return result;
        }
        else
        {
            log.info("Not found favorite companies");
            return new ArrayList<>();
        }
    }

    public ArrayList<String> getHubs()
    {
        if (isElementPresent(profilePage.getHubsTable())) {
            List<WebElement> subscriptions = profilePage.getHubNames();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement sub : subscriptions)
                result.add(sub.getText());
            log.info("Find favorite hubs: " + result);
            return result;
        }
        else
        {
            log.info("Not found favorite hubs");
            return new ArrayList<>();
        }
    }

    public String getProfileName()
    {
        String name = profilePage.getProfileName().getAttribute("href").split("/")[4];
        log.info("Get profile name "+name);
        return name;
    }

    public List<String> getTitleFavoritePosts()
    {
        ArrayList<String> titles = new ArrayList<>();
        for(WebElement p : profilePage.getFavoritesPost())
            titles.add(p.getText());
        log.info("Find favorite posts: " + titles);
        return titles;
    }

    public String getTitleFavoritePostByIndex(int index)
    {
        String title = getTitleFavoritePosts().get(index);
        log.info("Favorite post with index " + index + " has title "+ title);
        return title;
    }

    public ProfileSteps goToFavoritesTab()
    {
        profilePage.getFavoritesTab().click();
        wait.until(ExpectedConditions.visibilityOf(profilePage.getFavoritesTab()));
        log.info("Go to Закладки");
        return this;
    }
}
