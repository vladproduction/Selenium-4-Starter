package uitest.m5_select_elements;

import vladproduction.com.helper.DemoHelper;
import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class ByCssTest {

    WebDriver driver;

    @Test
    public void byCssSelector(){
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        var datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        datePicker.sendKeys("09/Nov/2023");

        DemoHelper.pause();
    }

    @Test
    public void byCssSelector_2(){
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        var checkBox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkBox.click();

        DemoHelper.pause();
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
