package uitest.m9_refactoringCode_creating_Framework.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vladproduction.com.pages.Loans;

import static vladproduction.com.factory.DriverFactory.newChromeDriver;
import static vladproduction.com.pages.Loans.Period.ONE_MONTH;

public class PomAbstractionLevelThreeTest {

    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        driver = newChromeDriver();
    }

    @Test
    public void loansTest(){
        var page = Loans.loansPage(driver);
        page.goTo();
        page.enterBorrowAmount("2000");
        page.selectTimePeriod(ONE_MONTH);
        String message = page.getResultMessage();
        Assert.assertEquals(message, "You will pays us back 4000");
        //or
        page.verifyResultMessage("You will pays us back 4000");
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
