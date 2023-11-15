package uitest.m9_refactoringCode_creating_Framework.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vladproduction.com.pages.Loans2;

import static vladproduction.com.factory.DriverFactory.newChromeDriver;
import static vladproduction.com.pages.Loans2.PeriodLoans2.ONE_MONTH;

public class ChainMethodsDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        driver = newChromeDriver();
    }

    @Test
    public void loansTest(){
        var page = Loans2.loansPage(driver);
        String result = page.goTo()
                .enterBorrowAmount("500")
                .selectTimePeriod(ONE_MONTH)
                .getResultMessage();
        Assert.assertEquals(result, "You will pays us back 1000");

    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
