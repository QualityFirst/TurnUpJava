package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    public static void waitToBeClickable(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        if (locatorType.equals("xpath"))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }
        if (locatorType.equals("Id"))
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }
    }

    public static void waitToBeVisible(WebDriver driver, String locatorType, String locatorValue, int seconds)
    {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = driver.findElement(By.xpath(locatorValue));
        if (locatorType.equals("xpath"))
        {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        if (locatorType.equals("Id"))
        {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }
}
