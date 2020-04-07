package otusqa.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CommonSteps extends AbstractSteps {

    public CommonSteps(WebDriver driver) { super(driver);}

    public MainSteps signIn(String login, String password){
        MainSteps mainSteps = new MainSteps(driver)
                .openMainPage();
        if (!mainSteps.isSignIn())
            mainSteps.goToSignIn().signIn(login, password);
        return mainSteps;
    }
    public MainSteps signOut() throws Exception {
        MainSteps mainSteps = new MainSteps(driver)
                .openMainPage();
        if (mainSteps.isSignIn())
            return mainSteps.signOut();
        else
            return mainSteps;

    }
}
