package uitest.m7_config_webDriver;

import vladproduction.com.helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Map;

import static vladproduction.com.helper.Pages.HOME;

public class DeviceEmulationTest {

    @Test
    public void deviceEmulationTest(){

        Map<String, String> mobileEmulation = Map.of("deviceName", "iPhone SE");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);

        DemoHelper.pause();
        driver.quit();
    }
}
