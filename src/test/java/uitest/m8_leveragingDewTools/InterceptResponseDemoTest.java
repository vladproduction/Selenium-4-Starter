package uitest.m8_leveragingDewTools;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InterceptResponseDemoTest {

    WebDriver driver;
    DevTools devTools;


    @Test
    public void captureResponseTraffic(){
        driver = new ChromeDriver();
        devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(), Optional.empty()));

        //here we care only about responses
        devTools.addListener(Network.responseReceived(),
                responseReceived -> {
                    Response r = responseReceived.getResponse();
                    System.out.printf("Response status: %s;\n", r.getStatus());
                    //Assert.assertTrue(r.getStatus() <= 400); //passed test
                    Assert.assertFalse(r.getStatus() <= 400); // should fail, but it still passed,
                    //do the check in other way 'captureResponseTrafficListOfResponsesByStatus'
                }
                );

        //finally we go to desired page:
        driver.get("http://localhost:8080/web/index.html");
    }

    @Test
    public void captureResponseTrafficListOfResponsesByStatus(){
        driver = new ChromeDriver();
        devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(), Optional.empty()));

        List<Integer> statuses = new ArrayList<>();
        //here we care only about responses
        devTools.addListener(Network.responseReceived(),
                responseReceived -> {
                    Response r = responseReceived.getResponse();
                    System.out.printf("Response status: %s;\n", r.getStatus());
                    //Assert.assertTrue(r.getStatus() <= 400); //passed test
                    //Assert.assertFalse(r.getStatus() <= 400); // should fail, but it still passed,
                    //do the check in other way, we create ArrayList() of statuses
                    statuses.add(r.getStatus());
                }
        );

        driver.get("http://localhost:8080/web/index.html");
        //looping over the collecting data and wright the assertion:
        //statuses.forEach(status-> Assert.assertFalse(status<=400)); //should fail - and it does
    }

    @AfterMethod
    public void cleanUp(){
        devTools.send(Network.disable());
        devTools.close();
        driver.quit();
    }
}
