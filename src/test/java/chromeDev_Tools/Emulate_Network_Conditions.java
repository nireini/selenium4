package chromeDev_Tools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v85.network.Network.loadingFailed;

public class Emulate_Network_Conditions extends Hooks {

    public static void emulateNetwork_online(DevTools devTools){
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(false, 100, 200000, 100000, Optional.of(ConnectionType.WIFI)));

    }

    public void emulateNetwork_Offline(DevTools devTools){
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(true, 100, 200000, 100000, Optional.of(ConnectionType.WIFI)));

        devTools.addListener(loadingFailed(), loadingFailed -> System.out.println("Error Text: " + loadingFailed.getErrorText()));

    }

    @Test
    public void emulateNetworkConditions(){
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // emulate online network conditions
        //emulateNetwork_online(devTools);

        // emulate offline mode
        emulateNetwork_Offline(devTools);


        long StartTime = System.currentTimeMillis();
        driver.get("https://www.automationteststore.com/");
        long EndTime = System.currentTimeMillis();

        System.out.println("Page load in: " + (EndTime-StartTime));
        //CELLULAR 2G - PAGE LOAD 5897
        // WIFI - PAGE LOAD 5616


    }
}
