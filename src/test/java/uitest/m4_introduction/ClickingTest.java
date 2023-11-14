package uitest.m4_introduction;

import helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class ClickingTest {

    @Test
    public void clickingTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        WebElement textarea = driver.findElement(By.id("textarea"));
        WebElement checkBox = driver.findElement(By.id("heard-about"));
        WebElement registerBtn = driver.findElement(By.id("register"));

        checkBox.click();    //checkBox stands active now
        textarea.sendKeys("Hello World!");
        registerBtn.click();
        DemoHelper.pause();

        driver.quit();

    }

    @Test
    public void moreClickingTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        WebElement checkBox = driver.findElement(By.id("heard-about"));
        Actions actions = new Actions(driver); //using some hidden methods like doubleClick for example
        actions.doubleClick(checkBox).perform();//have to finish chain with perform() to use actions
        actions.contextClick().perform(); //performing right click

        //in invoked window now we can not use any options, because it came from browser options;
        DemoHelper.pause();
        driver.quit();

    }
}
