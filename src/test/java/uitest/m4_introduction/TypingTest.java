package uitest.m4_introduction;

import helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class TypingTest {

    @Test
    public void typingTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));

        firstName.sendKeys("David");
        lastName.sendKeys("Bower");
        email.sendKeys("bower@email.test");
        DemoHelper.pause();
        email.clear();
        email.sendKeys("bower@email.test");
        DemoHelper.pause();
        dob.sendKeys("22Jan2000");//???
        System.out.println("dob = " + dob); //???
        DemoHelper.pause();
        DemoHelper.pause();
        driver.quit();
    }
}
