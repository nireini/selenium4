package base.browserOptions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox_options {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://www.webdriveruniversity.com/");
        driver.manage().window().maximize();
        driver.quit();

    }
}
