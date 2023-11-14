package uitest.m7_config_webDriver;

import helper.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class HandleAlertsByDefaultTest {

    @Test
    public void handleAlertsByDefaultTest(){
        //to handle some scenario of defaults alerts and do not catch any exceptions:
        //let`do in a middle of the test script

        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        //or
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);

        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);



        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("register")).click(); //UnhandledAlertException

        DemoHelper.pause();
        driver.quit();
    }
}
