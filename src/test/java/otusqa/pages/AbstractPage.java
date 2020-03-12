package otusqa.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver d)
    {
        driver = d;
    }

}
