package uitest.m6_advance_options;

import helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class WindowsManagementTest {

    //tabs and how to switch between windows:

    @Test
    public void tabsAndWindowsTest(){
        WebDriver driver = new ChromeDriver(); //new window with single tab created now
        driver.get(HOME);

        String firstTab = driver.getWindowHandle();
        DemoHelper.pause();
        driver.switchTo().newWindow(WindowType.TAB);//new tab will open(creating) now
        //driver.switchTo().newWindow(WindowType.WINDOW); //new hole window will open now
        driver.get(SAVINGS); //navigate to other tab

        //let`s check how many opened tabs we have right now:
        Assert.assertEquals(driver.getWindowHandles().size(), 2);
        DemoHelper.pause();

        driver.switchTo().window(firstTab); //switching on existing tab
        DemoHelper.pause();
        driver.close(); //closing only just one tab where we are right now
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        DemoHelper.pause();

        driver.quit(); //the main difference of close(), is that quit driver at all
    }
}
