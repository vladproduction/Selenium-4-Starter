package uitest.m7_config_webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class HeadlessDemoTest {

    @Test
    public void headlessTest(){

        //test will be run without showing page to us, so it is much faster to test it and no spending time

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless=true");
        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);

        WebElement registerBtn = driver.findElement(By.id("register"));
        System.out.println(registerBtn.getText());

        //to testing other browser at time we have to create a respective options
//        FirefoxOptions = new FirefoxOptions();
//        firefoxOptions.set...

        driver.quit();
    }
}
