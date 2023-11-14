package uitest.m6_advance_options;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class StorageTest {

    @Test
    public void storageTest(){

        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        var firstName = driver.findElement(By.id("firstName"));
        var lastName = driver.findElement(By.id("lastName"));
        var save = driver.findElement(By.id("save"));

        firstName.sendKeys("Jack");
        lastName.sendKeys("Blanch");
        save.click();

        //now we want to read values from selenium storage;
        WebStorage webStorage = (WebStorage) driver;
        SessionStorage storage = webStorage.getSessionStorage();
        storage.keySet()
                        .forEach(key-> System.out.println(key + " = " + storage.getItem(key)));
        DemoHelper.pause();
        driver.get(SAVINGS);
        driver.navigate().back();

        DemoHelper.pause();

        var firstName1 = driver.findElement(By.id("firstName"));
        var lastName1 = driver.findElement(By.id("lastName"));
        String nameA = firstName1.getAttribute("value");
        String nameB = lastName1.getAttribute("value");
        Assert.assertEquals(nameA, "Jack");
        Assert.assertEquals(nameB, "Blanch");


        driver.quit();
    }

    @Test
    public void storageRefreshTest(){

        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        var firstName = driver.findElement(By.id("firstName"));
        var lastName = driver.findElement(By.id("lastName"));
        var save = driver.findElement(By.id("save"));

        firstName.sendKeys("Jack");
        lastName.sendKeys("Blanch");
        save.click();

        //now we want to read values from selenium storage;
        WebStorage webStorage = (WebStorage) driver;
        SessionStorage storage = webStorage.getSessionStorage();
        storage.keySet()
                .forEach(key-> System.out.println(key + " = " + storage.getItem(key)));
        DemoHelper.pause();
        driver.get(SAVINGS);
        driver.navigate().back();

        DemoHelper.pause();

        var firstName1 = driver.findElement(By.id("firstName"));
        var lastName1 = driver.findElement(By.id("lastName"));
        String nameA = firstName1.getAttribute("value");
        String nameB = lastName1.getAttribute("value");
        Assert.assertEquals(nameA, "Jack");
        Assert.assertEquals(nameB, "Blanch");

        storage.clear();
        driver.navigate().refresh();

        DemoHelper.pause();
        //expecting the empty storage now:
        var firstName2 = driver.findElement(By.id("firstName"));
        var lastName2 = driver.findElement(By.id("lastName"));
        String name_A = firstName2.getAttribute("value");
        String name_B = lastName2.getAttribute("value");
        Assert.assertEquals(name_A, "");
        Assert.assertEquals(name_B, "");

        driver.quit();
    }
}
