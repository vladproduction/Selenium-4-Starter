package uitest.m4_introduction;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static helper.Pages.HOME;

public class FindMultipleElementsTest {

    @Test
    public void multipleElementsNoValuePrintTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        DemoHelper.pause();
        driver.quit();
    }

    @Test
    public void multipleElementsValuePrintTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        driver.findElement(By.id("register")).click();
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        DemoHelper.pause();
        driver.quit();
    }

    private void print(String text){
        System.out.printf("Feedback: %s\n", text);
    }
}
