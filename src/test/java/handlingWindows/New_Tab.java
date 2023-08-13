package handlingWindows;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class New_Tab extends Hooks {

    @Test
    public void newTab() throws InterruptedException {

        driver.get("https://www.webdriveruniversity.com/");
        String originalWindow = driver.getWindowHandle(); //store the id of the original tab

        //open and switch to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        String newWindow = driver.getWindowHandle();

        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

        //output unique tab id
        System.out.println("Original Window: " + originalWindow + "\nNewWindow: " + newWindow);

        //close the newest tab
        driver.close();

        //open new tab by interacting with homepage html element button
        driver.switchTo().window(originalWindow);
        WebElement loginPortal_Button = driver.findElement(By.id("login-portal"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginPortal_Button)).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Switch too & validate the title of the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        System.out.println("Title " + driver.getTitle());
        wait.until(ExpectedConditions.titleIs("WebDriver | Login Portal"));

        //switch to the first original tab, then close the most recent tab
        driver.switchTo().window(originalWindow);

        // switch to and close the most recent tab
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.close();

        driver.switchTo().window(originalWindow);
        System.out.println("original tab title is: " + driver.getTitle());



        Thread.sleep(0);
    }
}
