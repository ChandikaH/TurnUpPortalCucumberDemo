package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    public void NavigateToTimeMaterialPage(WebDriver webDriver) {
        try {
            //Navigate to Time and Material module (click Administration button -> Select Time & Material Option)
            WebElement administrationDropdown = webDriver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/ul[1]/li[5]/a[1]"));
            administrationDropdown.click();
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a")));

            WebElement tmOption = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
            tmOption.click();
        } catch (Exception ex) {
            Assert.fail("TurnUp portal page did not displayed" + ex.getMessage());
        }
    }

    public void NavigateToEmployeePage(WebDriver webDriver) {
        try {
            //Navigate to Time and Material module (click Administration button -> Select Employee Option)
            WebElement administrationDropdown = webDriver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/ul[1]/li[5]/a[1]"));
            administrationDropdown.click();
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a")));

            WebElement employeeOption = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
            employeeOption.click();
        } catch (Exception ex) {
            Assert.fail("TurnUp portal page did not displayed" + ex.getMessage());
        }
    }

    public void VerifyLoggedInUser(WebDriver webDriver) {
        try {
            //Check if user has logged in successfully
            WebElement helloHariLink = webDriver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a"));
            System.out.println("User Logged in to TurnUp portal successfully.");
            Assert.assertEquals(helloHariLink.getText(), "Hello hari!", "User hasn't been logged in.");
        } catch (Exception ex) {
            Assert.fail("User hasn't logged in :(" + ex.getMessage());
        }
    }
}
