package base.browserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_options {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, "Windows 11");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.webdriveruniversity.com/");
        //driver.manage().window().maximize();
        driver.quit();
    }
}
