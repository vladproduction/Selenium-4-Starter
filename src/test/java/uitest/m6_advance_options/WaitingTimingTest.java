package uitest.m6_advance_options;

import vladproduction.com.helper.DemoHelper;
import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static vladproduction.com.helper.Pages.LOANS;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitingTimingTest {

    WebDriver driver;

    @Test
    public void implicitWaitTest() {
        //implicit wait is a global configuration on  driver level

        //create new webDriver, so from DriverFactory
        //do not use: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver = new ChromeDriver();
        driver.get(LOANS);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(By.id("borrow")).sendKeys("500");
        //test failed because isDisplayed() are not effected by implicit waiting configuration!
        //so I comment it:
//        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

        System.out.println("waiting time till element will active, and then click() on it");
        //click() method play when element is visible and interactive
        //now test passed
        driver.findElement(By.id("result")).click();

    }

    @Test
    public void explicitWaitTest(){
        //is for individual options:
        driver = new ChromeDriver();
        driver.get(LOANS);

        driver.findElement(By.id("borrow")).sendKeys("500");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6)); //specifying maximum waiting time

        WebElement result = wait.until(visibilityOfElementLocated(By.id("result")));
        //after that string, element located 'result' will wait 6 sec

        Assert.assertTrue(result.isDisplayed());
        result.click();  // interactable?

    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator){
        return new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(elementToBeClickable(locator));

    }

    @Test
    public void explicitWaitTestRefactored(){
        driver = new ChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");
        WebElement result = waitUntilClickable(driver, By.id("result"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void fluentWaitTest(){
        //such kind runaway test is adjustable for time checking till condition met sooner than explicit time
        //testing candidate of webElement to be clickable is waiting for action
        driver = DriverFactory.newDriver();
        driver.get(LOANS);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(6)) //time waiting
                        .pollingEvery(Duration.ofMillis(200)) //checking pooling by
                        .ignoring(NoSuchElementException.class); //what to ignore in case of

        driver.findElement(By.id("borrow")).sendKeys("500");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        element.click();
    }

    @AfterMethod
    public void cleanUp() {
        DemoHelper.pause();
        driver.quit();
    }
}