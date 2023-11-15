package uitest.m5_select_elements;

import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class RelativeLocatorsTest {

    WebDriver driver;

    @Test
    public void relativeLocator(){

        driver = DriverFactory.newDriver();
        driver.get(HOME);

        //take as center locator 'email'
        WebElement email = driver.findElement(By.id("email"));
        RelativeLocator.RelativeBy input = RelativeLocator.with(By.tagName("input"));
        //find to us: what is right side of email
        WebElement datePicker = driver.findElement(input.toRightOf(email));
        System.out.println(datePicker.getAttribute("type"));  //datePicker

        //find to us: what is above side of email
        WebElement firstName = driver.findElement(input.above(email));
        System.out.println(firstName.getAttribute("id"));  //firstName

        //find to us: what is above side of email
        WebElement checkbox = driver.findElement(input.below(email));
        System.out.println(checkbox.getAttribute("type"));  //checkbox

    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
