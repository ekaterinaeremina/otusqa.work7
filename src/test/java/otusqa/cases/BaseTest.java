package otusqa.cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import otusqa.WebDriverFactory;
import otusqa.WebDriverName;

import java.util.ArrayList;

public class BaseTest {
    protected static WebDriver driver;
    private static final Logger log = Logger.getLogger(BaseTest.class);
    protected static String browser = System.getProperty("browser").toUpperCase();
    protected static String login = System.getProperty("login");
    protected static String password = System.getProperty("password");

    @BeforeClass
    public static void setUp()
    {
        driver = WebDriverFactory.create(WebDriverName.valueOf(browser));
        driver.manage().window().maximize();
        log.info("Setup driver");
    }

    public ArrayList<String> getBrowserTabs(){
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void selectBrowserTab(int index){
        driver.switchTo().window(getBrowserTabs().get(index));
    }

    @AfterClass
    public static void tearDown()
    {
        if (driver!=null) {
            driver.quit();
            driver = null;
        }
        log.info("Driver quit");
    }
}
