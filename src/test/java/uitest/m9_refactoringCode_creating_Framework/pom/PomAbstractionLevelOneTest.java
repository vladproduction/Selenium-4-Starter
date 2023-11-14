package uitest.m9_refactoringCode_creating_Framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import java.util.List;

import static factory.DriverFactory.newChromeDriver;

public class PomAbstractionLevelOneTest {

    WebDriver driver;

    @BeforeMethod
    public void initDriver(){
        driver = newChromeDriver();
    }

    @Test
    public void homePageTest(){
        var homePage = Home.homePage(driver);

        homePage.goTo();
        homePage.firstName().sendKeys("John");
        homePage.lastName().sendKeys("");
        homePage.registerBtn().click();
        List<WebElement> feedBackList = homePage.invalidElements();

        Assert.assertFalse(feedBackList.get(0).isDisplayed());
        Assert.assertEquals(feedBackList.get(1).getText(), "Valid last name is required");

    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}
