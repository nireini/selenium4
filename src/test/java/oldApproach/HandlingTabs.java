package oldApproach;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class HandlingTabs extends Hooks {
    @Test
    public void oldApproach_HandlingTabs() throws InterruptedException {

        driver.get("http://www.webdriveruniversity.com/Page-Object-Model/index.html");

        //open link in new tab
        WebElement contactUs_Link = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));

        contactUs_Link.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

        //Switch to most recent tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        driver.close(); //close the most recent tab
        driver.switchTo().window(tabs.get(0)); // switch back to the default tab (window)

        //open a blank new tab using javascript & navigate to a URL
        ((JavascriptExecutor) driver).executeScript("window.open");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get("https://www.webdriveruniversity.com/");

        Thread.sleep(1000);
    }
}
