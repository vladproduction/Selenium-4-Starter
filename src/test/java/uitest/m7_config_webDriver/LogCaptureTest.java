package uitest.m7_config_webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;

import static vladproduction.com.helper.Pages.HOME;

public class LogCaptureTest {

    WebDriver driver;

    @Test
    public void logCaptureTest(){

        //Chromium only feature, does not work to FireFox
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.LOGGING_PREFS, logs);

        driver = new ChromeDriver(options);
        driver.get(HOME);
        driver.findElement(By.id("register")).click();

        //here how we collect logs and view them:
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        Assert.assertFalse(logEntries.getAll().isEmpty()); //test will pass if logsList is not empty
        //can print all of
        logEntries.forEach(System.out::println);
        //or we can print some specific by log and message
        logEntries.forEach(logEntry -> System.out.println(logEntry.getLevel() + " " + logEntry.getMessage()));

        //we can loop on logEntries and check if there is no Error
        logEntries.forEach(logEntry -> checkNoError(logEntry)); //if finding any error,- test fail
        //logEntries.forEach(this::checkNoError); //we can write so instead of lambda
    }

    private void checkNoError(LogEntry logEntry) {
        //Assert.assertNotEquals(logEntry.getLevel().getName(), "SEVERE");
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
