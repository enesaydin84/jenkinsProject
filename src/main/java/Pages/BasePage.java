package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        find(locator).click();
    }

    public void send(By locator,String text){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        find(locator).sendKeys(text);
    }

    public WebElement getElementLocated(By by){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    public boolean getElementLocatedControl(By locator){
        WebDriverWait wait=new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean isDisplaed(By locator){
        try {
            if (getElementLocated(locator).isDisplayed()){
                return true;
            }
        }catch (TimeoutException e){
            return false;
        }
        return false;
    }

    public void waitForSeconds(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


}
