package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final String XPATH = "XPath";
    private static final String ID = "Id";
    private static final String CSS_SELECTOR = "CssSelector";
    private static final String NAME = "Name";

    public static void WaitToBeVisible(WebDriver webDriver, String locatorType, String locatorValue, int seconds) {
        //c# -> WebDriverWait webDriverWait = new WebDriverWait(webDriver, TimeSpan.FromSeconds(seconds));
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        if (locatorType == XPATH) {
            //c# -> webDriverWait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(By.xpath(locatorValue)));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        }
        if (locatorType == ID) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        }
        if (locatorType == CSS_SELECTOR) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
        }
        if (locatorType == NAME) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
        }
    }

    public static void WaitToBeClickable(WebDriver webDriver, String locatorType, String locatorValue, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));

        if (locatorType == XPATH) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        }
        if (locatorType == ID) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        }
        if (locatorType == CSS_SELECTOR) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
        }
        if (locatorType == NAME) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
        }
    }

    public static void WaitToBeSelected(WebDriver webDriver, String locatorType, String locatorValue, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));

        if (locatorType == XPATH) {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(By.xpath(locatorValue)));
        }
        if (locatorType == ID) {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(By.id(locatorValue)));
        }
        if (locatorType == CSS_SELECTOR) {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(locatorValue)));
        }
        if (locatorType == NAME) {
            webDriverWait.until(ExpectedConditions.elementToBeSelected(By.name(locatorValue)));
        }
    }

    public static void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
