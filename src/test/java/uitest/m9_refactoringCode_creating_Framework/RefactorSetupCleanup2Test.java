package uitest.m9_refactoringCode_creating_Framework;

import vladproduction.com.base.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import vladproduction.com.wait.WaitingUtils;

import static vladproduction.com.helper.Pages.LOANS;

public class RefactorSetupCleanup2Test extends BaseTestClass {


    @Test
    public void refactoredTestDemo(){
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");
        var message = WaitingUtils.waitUtilVisible(driver, By.id("result"), 4);
        Assert.assertEquals(message.getText(), "You will pays us back 1000");
    }

    @Test
    public void refactoredTestDemoDuplicate(){
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("100");
        var message = WaitingUtils.waitUtilVisible(driver, By.id("result"), 3);
        Assert.assertEquals(message.getText(), "You will pays us back 200");
    }


}
