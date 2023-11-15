package uitest.m9_refactoringCode_creating_Framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vladproduction.com.pages.Savings;

import static vladproduction.com.factory.DriverFactory.newChromeDriver;
import static vladproduction.com.pages.Savings.Period.ONE_YEAR;

public class PomAbstractionLevelTwoTest {

    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        driver = newChromeDriver();
    }

    @Test
    public void savingsTest(){
        var page = Savings.savingsPage(driver);
        page.goTo();
        page.enterDeposit("500");
        page.selectTimePeriod(ONE_YEAR);
        WebElement message = page.resultMessage();

        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(message.getText(), "After 1 Year you will earn $25.00 on your deposit");
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
