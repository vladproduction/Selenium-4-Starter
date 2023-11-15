package uitest.m6_advance_options;

import vladproduction.com.helper.DemoHelper;
import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class HandleDialogTest {

    @Test
    public void dismissAlertTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        var firstName = driver.findElement(By.id("firstName"));
        var lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys("John");
        lastName.sendKeys("Dow");

        DemoHelper.pause();
        driver.findElement(By.id("clear")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(firstName.getAttribute("value"), "John");
        Assert.assertEquals(lastName.getAttribute("value"), "Dow");


        DemoHelper.pause();

        driver.quit();

    }

    @Test
    public void acceptAlertTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        var firstName = driver.findElement(By.id("firstName"));
        var lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys("John");
        lastName.sendKeys("Dow");

        DemoHelper.pause();
        driver.findElement(By.id("clear")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(firstName.getAttribute("value"), "");
        Assert.assertEquals(lastName.getAttribute("value"), "");


        DemoHelper.pause();

        driver.quit();

    }
}
