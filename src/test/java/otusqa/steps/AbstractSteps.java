package otusqa.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import otusqa.pages.AbstractPage;

public class AbstractSteps {
	//Test comment
    protected WebDriver driver;
    private static final Logger log = Logger.getLogger(AbstractPage.class);
    protected WebDriverWait wait;

    public AbstractSteps(WebDriver d)
    {
        driver = d;
        wait = new WebDriverWait(driver,30);
    }

    public void inputValue(WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
        log.info("Input " + value);
    }

    public void open(String url) {
        driver.get(url);
        log.info("open "+url);
    }

    public boolean isElementPresent(WebElement we) {
        try {
            we.getTagName();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
