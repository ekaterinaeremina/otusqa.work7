package otusqa.steps.settings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otusqa.pages.settings.ProfileSettingsPage;
import otusqa.steps.AbstractSteps;

public class ProfileSettingsSteps extends AbstractSteps {

    private static final Logger log = Logger.getLogger(ProfileSettingsSteps.class);
    private ProfileSettingsPage profileSettingsPage;

    public ProfileSettingsSteps(WebDriver driver) {
        super(driver);
        profileSettingsPage = new ProfileSettingsPage(driver);
    }

    public ProfileSettingsSteps waitLoading()
    {
        wait.until(ExpectedConditions.visibilityOf(profileSettingsPage.getHeader()));
        log.info("ProfileSettings loaded");
        return this;
    }

    public ProfileSettingsSteps inputRealName(String name)
    {
        inputValue(profileSettingsPage.getRealName(), name);
        return this;
    }

    public String getRealName()
    {
        String value = profileSettingsPage.getRealName().getAttribute("value");
        log.info("Поле Настоящее имя: " + value);
        return value;
    }
}
