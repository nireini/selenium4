package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

@Test
public class Explicit_wait extends Hooks {

    public void explicitWait(){

        driver.get("https://www.automationteststore.com/");

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.elementToBeClickable(By.id("customer_menu_top")));

        System.out.println(element.getText());
    }
}
