package uitest.m4_introduction;

import vladproduction.com.helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class AttributesTest {

    @Test
    public void isEnabledNegativeTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        WebElement textArea = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textArea.isEnabled());

        //ElementNotInteractableException if we try to wright something to not enabled textArea
        if(textArea.isEnabled()){
            //trying to wright something:
            textArea.sendKeys("some text to textArea"); //?
            System.out.println("isEnabled - true");
        }
        System.out.println("isEnabled - false");//false

        driver.quit();
    }

    @Test
    public void isEnabledPositiveTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        WebElement textArea = driver.findElement(By.id("textarea"));
        WebElement checkBox = driver.findElement(By.id("heard-about"));
        checkBox.click();
        Assert.assertTrue(textArea.isEnabled());

        if(textArea.isEnabled()){
            //trying to wright something
            textArea.sendKeys("some text to textArea");
            System.out.println("isEnabled - true"); //true
        }else {
            System.out.println("isEnabled - false");
        }
        DemoHelper.pause();
        driver.quit();
    }

    @Test
    public void isDisplayedTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        WebElement feedback = driver.findElement(By.className("invalid-feedback"));
        Assert.assertFalse(feedback.isDisplayed()); //says to us is not displayed

        driver.findElement(By.id("register")).click(); //activate action of button
        Assert.assertTrue(feedback.isDisplayed()); //passed because feedback is activated by clicking button

        DemoHelper.pause();
        driver.quit();
    }

}
