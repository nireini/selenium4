package waits;

import base.Hooks;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Page_Load extends Hooks {

        @Test
        public void pageLoad(){
            //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


            //ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            //driver = new ChromeDriver(chromeOptions);

            driver.get("https://www.automationteststore.com/");
        }
    }
