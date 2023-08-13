package chromeDev_Tools;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Emulate_Geo_Locations extends Hooks {

    @Test
    public void mulateGeoLocations() throws InterruptedException {

        Map<String, Object> coordinates = new HashMap<>();

        // 27.944881027866092, -82.47214867423682
        coordinates.put("latitude", 27.94488);
        coordinates.put("longitude", -82.47214);
        coordinates.put("accuracy", 100);

        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://locations.kfc.com/search");

        Thread.sleep(5000);
        WebElement location_icon = driver.findElement(By.cssSelector("button[data-ya-track=\"geolocate\"]"));
        location_icon.click();

        Thread.sleep(5000);

    }
}
