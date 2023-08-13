package actions;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Performing_Actions extends Hooks {

    @Test
    public void performingActions() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/Actions/index.html");

        // click and hold
        WebElement clickAndHold_Element = driver.findElement(By.id("click-box"));

        Actions actionsProvider =  new Actions(driver);

        actionsProvider.clickAndHold(clickAndHold_Element).build().perform();
        actionsProvider.release(clickAndHold_Element).build().perform();

        // drag and drop
        WebElement draggable_Element = driver.findElement(By.id("draggable"));
        WebElement droppable_Element = driver.findElement(By.id("droppable"));

        actionsProvider.moveToElement(draggable_Element).clickAndHold().moveToElement(droppable_Element).release().build().perform();

        //Double click
        WebElement doubleClick_Element = driver.findElement(By.id("double-click"));
        actionsProvider.doubleClick(doubleClick_Element).release().build().perform();

        Thread.sleep(5000);

    }
}
