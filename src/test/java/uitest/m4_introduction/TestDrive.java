package uitest.m4_introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestDrive {

    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();
        driver.getTitle();
        driver.quit();
    }

    @Test
    public void test2(){
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver(); driver.get("http://www.google.com/");
        try {
            Thread.sleep(5000); // Let the user actually see something!
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
