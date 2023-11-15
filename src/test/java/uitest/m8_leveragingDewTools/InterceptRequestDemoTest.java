package uitest.m8_leveragingDewTools;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class InterceptRequestDemoTest {

    WebDriver driver;
    DevTools devTools;

    //@Test
    public void howToGetDevToolsObject(){

        ChromeDriver chromeDriver = new ChromeDriver();
        DevTools tools1 = chromeDriver.getDevTools();

        WebDriver webDriverChrome = new ChromeDriver();
        DevTools tools2 = ((ChromeDriver) webDriverChrome).getDevTools();

    }

    @Test
    public void captureRequestTraffic(){
        driver = new ChromeDriver();
        devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();
        //in case we have multiple open windows, we past as a parameter handledWindow:
        //devTools.createSession(driver.getWindowHandle());
        /*each tab has it`s oun devTools panel,
        * programmatically we can start recording current traffic we need to check */
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(), Optional.empty()));
        //we have to add listener(request:js files, css, ets; what to do with it: implementing listener by lambda)
        devTools.addListener(Network.requestWillBeSent(),
                requestEvent -> {
                    Request r = requestEvent.getRequest();
                    System.out.printf("URL: %s; Method: %s;\n", r.getUrl(), r.getMethod());
                }
                );
        //finally we go to desired page:
        driver.get("http://localhost:8080/web/index.html");
    }

    @AfterMethod
    public void cleanUp(){
        devTools.send(Network.disable());
        devTools.close();
        driver.quit();
    }
}
