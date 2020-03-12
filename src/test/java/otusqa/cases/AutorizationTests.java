package otusqa.cases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import otusqa.steps.*;

public class AutorizationTests extends BaseTest {

    private static final Logger log = Logger.getLogger(AutorizationTests.class);

    @Test(priority=1)
    public void SignInTest() throws Exception {
        log.info("Start SignInTest");
        CommonSteps commonSteps = new CommonSteps(driver);
        MainSteps mainSteps = commonSteps.signIn(login, password);
        boolean actual = mainSteps.isSignIn();
        boolean excepted = true;
        log.info("AssertEquals: is SignIn? - " + actual + ", excepted - "+excepted);
        Assert.assertEquals(actual, excepted);
        log.info("End SignInTest");
    }

    @Test(priority=2)
    public void SignOutTest() throws Exception {
        log.info("Start SignOutTest");
        CommonSteps commonSteps = new CommonSteps(driver);
        MainSteps mainSteps = commonSteps.signIn(login,password);
        commonSteps.signOut();
        boolean actual = mainSteps.isSignIn();
        boolean excepted = false;
        log.info("AssertEquals: is SignIn? - " + actual + ", excepted - "+excepted);
        Assert.assertEquals(actual, excepted);
        log.info("End SignOutTest");
    }

}
