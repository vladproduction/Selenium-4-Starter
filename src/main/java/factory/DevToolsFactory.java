package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;

import java.util.Optional;

public class DevToolsFactory {

    public static DevTools newChromeDevTool(WebDriver driver){
        DevTools devTools = ((ChromeDriver)driver).getDevTools();//init devTools by driver sets in param
        devTools.createSession();//start session
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),Optional.empty()));//start listener of the traffic
        return devTools;
    }
}
