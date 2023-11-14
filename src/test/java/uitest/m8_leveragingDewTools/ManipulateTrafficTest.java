package uitest.m8_leveragingDewTools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class ManipulateTrafficTest {

    WebDriver driver;
    DevTools devTools;
    @Test
    public void manipulateTrafficTest(){
        driver = new ChromeDriver();
        devTools = getDevTools(driver);
        //now we can use setBlockedUrls method, so it ability to block some kinds of files
        //devTools.send(Network.setBlockedURLs(List.of("*.js")));//wildcard useful
        //devTools.send(Network.setBlockedURLs(List.of("*/footer.js")));//could be specific target as well

        driver.get("http://localhost:8080/web/index.html");
//        WebElement location = new WebDriverWait(driver, Duration.ofSeconds(2))
//                .until(visibilityOfElementLocated(By.id("located")));
        //Assert.assertTrue(location.getText().contains("You are visiting us from Europe/Kiev"));
        //if we comment send(), test pass
    }

    @AfterMethod
    public void cleanUp(){
        devTools.send(Network.disable());
        devTools.close();
        driver.quit();
    }

    private static DevTools getDevTools(WebDriver driver){
        DevTools devTools = ((ChromeDriver)driver).getDevTools();//init devTools by driver sets in param
        devTools.createSession();//start session
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),Optional.empty()));//start listener of the traffic
        return devTools;
    }
}
