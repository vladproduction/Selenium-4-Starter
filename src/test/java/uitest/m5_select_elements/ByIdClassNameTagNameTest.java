package uitest.m5_select_elements;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class ByIdClassNameTagNameTest {

    WebDriver driver;

    @Test
    public void byIdTest(){
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        driver.findElement(By.id("register")).click();
    }

    @Test
    public void byClassNameTest(){
        driver = DriverFactory.newDriver();
        driver.get(HOME);
        driver.findElement(By.id("register")).click();

        //not good idea to write like this,- it return only first match element of the class
        WebElement firstName = driver.findElement(By.className("invalid-feedback"));

        //good suggesting is to use find elements in plural, so finding all matched element by class;
        List<WebElement> feedbackList = driver.findElements(By.className("invalid-feedback"));
        //for each element we can expect:
        Assert.assertEquals(feedbackList.get(0).getText(), "Valid first name is required");
        Assert.assertEquals(feedbackList.get(1).getText(), "Valid last name is required");
        Assert.assertEquals(feedbackList.get(2).getText(), "Please enter a valid email address");

        driver.quit();
    }

    @Test
    public void byTagNameTest(){
        driver = DriverFactory.newDriver();
        driver.get(SAVINGS);

        var tableById = driver.findElement(By.id("rates"));

        var tableByTag = driver.findElement(By.tagName("table"));

        System.out.println(tableById.getText());
        System.out.println(tableByTag.getText());
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

}
