package screenshot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot extends Hooks {

    @Test
    public void screeshot() throws IOException {
        driver.get("https://www.automationteststore.com/");

        // capture screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./auto_test_store.png"));

        // element screenshot
        WebElement home_button = driver.findElement(By.xpath("//a[text()='Home']"));
        srcFile = home_button.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./home_button.png"));

    }
}
