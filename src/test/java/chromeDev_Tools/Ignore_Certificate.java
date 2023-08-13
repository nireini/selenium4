package chromeDev_Tools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.security.Security;
import org.testng.annotations.Test;

public class Ignore_Certificate extends Hooks {

    @Test
    public void ignoreCertificate() {
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        devTools.send(Security.enable());
        devTools.send(Security.setIgnoreCertificateErrors(true));

        driver.get("https://www.automationteststore.com/");
    }
}
