package chromeDev_Tools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

public class Capture_Netwrok_Traffic extends Hooks {

    @Test
    public void captureNetworkTraffic() {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                entry ->
                        System.out.println("Request URL: " + entry.getRequest().getUrl() + "\n"
                                + " With Method " + entry.getRequest().getMethod()));

        driver.get("https://www.automationteststore.com/");
        devTools.send(Network.disable()); // stop capturing network traffic



    }
}
