package uitest.m6_advance_options;

import vladproduction.com.helper.DriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static vladproduction.com.helper.Pages.HOME;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotPageTest {

    @Test
    public void fullPageScreenshotTest() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        TakesScreenshot ts = (TakesScreenshot)driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("failure-screenshot.png");
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);


        driver.quit();
    }

    @Test
    public void elementPageScreenshotTest() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement form = driver.findElement(By.tagName("form"));
        File screenshot = form.getScreenshotAs(OutputType.FILE);

        Path destination = Paths.get("failure-screenshot.png");
        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);


        driver.quit();
    }
}
