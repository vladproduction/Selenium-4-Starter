package uitest.m8_leveragingDewTools;

import helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

import static helper.Pages.HOME;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GeoLocationDemoTest {

    @Test
    public void geoLocationTest(){
        ChromeDriver driver = new ChromeDriver();
        DevTools tools = driver.getDevTools();
        tools.createSession();
        tools.send(Emulation.setGeolocationOverride(
                Optional.of(51.504629500995215),
                Optional.of( -0.07600681681365794),
                Optional.of(100)));
        driver.get(HOME);
        WebElement location = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(visibilityOfElementLocated(By.id("location")));
        Assert.assertEquals(location.getText(), "You are visiting us from London");

        DemoHelper.pause();
        tools.close();
        driver.quit();
    }
}
