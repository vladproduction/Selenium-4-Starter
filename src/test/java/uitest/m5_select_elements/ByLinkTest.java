package uitest.m5_select_elements;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class ByLinkTest {

    WebDriver driver;

    @Test
    public void byLinkTest(){
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        driver.findElement(By.linkText("Savings")).click();
        DemoHelper.pause();
        driver.findElement(By.partialLinkText("Reg")).click();
        DemoHelper.pause();
        driver.findElement(By.linkText("Loans")).click();
        DemoHelper.pause();
        driver.findElement(By.partialLinkText("Reg")).click();
        DemoHelper.pause();

        driver.quit();
    }



}
