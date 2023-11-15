package uitest.m5_select_elements;

import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;
import static vladproduction.com.helper.Pages.SAVINGS;

public class ByXPathTest {

    WebDriver driver;

    @Test
    public void byXpath_1(){
        driver = DriverFactory.newDriver();
        driver.get(SAVINGS);

        // copy full Xpath
        var cell_1 = driver.findElement(
                By.xpath("/html/body/main/div/div/div/form/div/div[4]/table/tbody/tr[1]/td[4]"));
        System.out.println("Chrome full xpath: " + cell_1.getText());

        // copy Xpath
        var cell_2 = driver.findElement(
                By.xpath("//*[@id=\"rates\"]/tbody/tr[1]/td[4]"));
        System.out.println("Chrome xpath: " + cell_2.getText());
    }

    @Test
    public void byXpath_2(){
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        // constructed our own Xpath by browser (on open page 'Ctrl+F' +  build xpath())
        var button_1 = driver.findElement(By.xpath("//form/button[contains(text(),'Register')]"));
        System.out.println(button_1.getText());
        var button_2 = driver.findElement(By.xpath("//form/button[contains(text(),'Save input')]"));
        System.out.println(button_2.getText());

    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
