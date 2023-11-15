package vladproduction.com.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitingUtils {

    public static WebElement waitUtilClickable(WebDriver driver, By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(elementToBeClickable(locator));
    }

    public static WebElement waitUtilVisible(WebDriver driver, By locator, int seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(elementToBeClickable(locator));
    }
}
