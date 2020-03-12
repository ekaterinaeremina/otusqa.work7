package otusqa.helpers;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsHelper {

    public static void switchToLastWindow(WebDriver driver)
    {
        Set<String> allHandles = driver.getWindowHandles();
        String[] array = allHandles.toArray(new String[allHandles.size()]);
        driver.switchTo().window(array[array.length-1]);
    }
}
