package handlingWindows;

import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class New_Window extends Hooks {

    @Test
    public void newWindow() throws InterruptedException {
        driver.get("https://www.webdriveruniversity.com/");

        //open new window and access another url
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.automationteststore.com/");

        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(0));
        System.out.println(driver.getCurrentUrl()); //https://www.webdriveruniversity.com/

        Thread.sleep(1500);

        driver.switchTo().window(window.get(1));
        System.out.println(driver.getCurrentUrl()); //https://www.automationteststore.com/
        driver.close();

        //switch back to original window and output the url
        driver.switchTo().window(window.get(0));
        System.out.println(driver.getCurrentUrl()); //https://www.webdriveruniversity.com/


    }


}
