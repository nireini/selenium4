package actions;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class get_Element extends Hooks {

    public void getElement(String value, int timeout, boolean mandatory){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        WebElement element = null;

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));

    }

    public Boolean CheckIfElementIsDisplayed2(String value) throws InterruptedException {

        Thread.sleep(10000);

        Boolean isPresent = driver.findElements(By.xpath(value)).size() > 0;

        return isPresent;
    }
}
