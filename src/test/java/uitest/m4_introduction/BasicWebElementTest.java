package uitest.m4_introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class BasicWebElementTest {

    @Test
    public void webElementTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        //textField
        WebElement firstName = driver.findElement(By.id("firstName"));//specify how we want to find element (By.id())
        System.out.println(firstName.isDisplayed()); //return 'true' if element displayed;

        //registerButton
        WebElement registerButton = driver.findElement(By.id("register"));
        System.out.println(registerButton.getText()); //'Register' we will see

        //important to have the right names for variables

        driver.quit();
    }
}
