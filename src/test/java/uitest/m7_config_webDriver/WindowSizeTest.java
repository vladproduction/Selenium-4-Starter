package uitest.m7_config_webDriver;

import vladproduction.com.helper.DemoHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static vladproduction.com.helper.Pages.HOME;

public class WindowSizeTest {

    @Test
    public void windowSizeTest(){
        WebDriver driver = new ChromeDriver();
        WebDriver.Window window = driver.manage().window();

        window.maximize();
        window.minimize();
        window.setSize(new Dimension(1200,900));

        driver.get(HOME);


        DemoHelper.pause();
        driver.quit();
    }
}
