package vladproduction.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {

    //private static final String URL = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";
    private static final String URL = "http://localhost:8080/web/index.html";
    private final WebDriver driver;

    private Home(WebDriver driver) {
        this.driver = driver;
    }

    //static factory method:
    public static Home homePage(WebDriver driver){
        return new Home(driver); //encapsulate of creating new page with certain driver
    }

    public void goTo(){
        driver.get(URL);
    }

    public WebElement firstName(){
        return driver.findElement(By.id("firstName"));
    }

    public WebElement lastName(){
        return driver.findElement(By.id("lastName"));
    }

    public WebElement registerBtn(){
        return driver.findElement(By.id("register"));
    }

    public List<WebElement> invalidElements(){
        return driver.findElements(By.className("invalid-feedback"));
    }
}
