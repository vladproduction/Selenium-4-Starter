package uitest.m6_advance_options;

import helper.DriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesTest {

    @Test
    public void cookiesTest(){
        WebDriver driver = DriverFactory.newDriver();
        WebDriver.Options options = driver.manage();

        Set<Cookie> cookies = options.getCookies();
        Cookie thing = options.getCookieNamed("thing");
        options.deleteAllCookies();

        driver.quit();
    }
}
