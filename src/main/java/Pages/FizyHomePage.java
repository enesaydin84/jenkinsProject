package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FizyHomePage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 3);
    By webPlayerFastLogin = new By.ByXPath("//a[@id='webPlayerHeader']");

    public FizyHomePage(WebDriver driver) {
        super(driver);
    }

    public void gotoFastLoginPage() {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;
        System.out.println(driver.getWindowHandles().size());
        click(webPlayerFastLogin);
        waitForSeconds(2);
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Küçük pencere");
                break;
            }
        }

        driver.switchTo().window(originalWindow);
        System.out.println("orjinal window");
    }
}
