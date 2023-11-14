package uitest.m9_refactoringCode_creating_Framework;

import factory.DevToolsFactory;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;
import org.testng.annotations.Test;
import wait.WaitingUtils;

import java.time.Duration;

import static factory.DriverFactory.*;
import static helper.DriverFactory.*;
import static helper.Pages.LOANS;

public class BasicRefactoringDemoTest {

    @Test
    public void beforeRefactoring(){
        //setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless=true");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //do things
    }

    @Test
    public void newDriverAndToolsDemo(){

        WebDriver chromeDriver = newChromeDriver();

        WebDriver firefoxDriver = newFirefoxDriver();

        WebDriver iPhoneSE = newDevice("iPhoneSE");

        DevTools tools = DevToolsFactory.newChromeDevTool(chromeDriver);

        chromeDriver.quit();
        tools.close();
        firefoxDriver.quit();
    }

    @Test
    public void refactoredTestDemo(){

        var driver = newChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");
        var message = WaitingUtils.waitUtilVisible(driver, By.id("result"), 6);

        Assert.assertEquals(message.getText(), "You will pays us back 1000");
        driver.quit();

    }
}
