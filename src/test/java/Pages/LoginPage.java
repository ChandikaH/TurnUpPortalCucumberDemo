package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {
    private final By userNameTextboxLocator = By.id("UserName");
    private final By passwordTextboxLocator = By.id("Password");
    private final By loginButtonLocator = By.xpath("//*[@id='loginForm']/form/div[3]/input[1]");
    WebElement usernameTextbox;
    WebElement passwordTextbox;
    WebElement loginButton;

    public void LoginActions(WebDriver webDriver, String username, String password) {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Launch turnUp Portal and navigate to login page
        String baseURL = "http://horse.industryconnect.io/Account/Login";
        webDriver.navigate().to(baseURL);

        //Identify username textbox and enter valid username
        usernameTextbox = webDriver.findElement(userNameTextboxLocator);
        usernameTextbox.sendKeys(username);

        //Identify password textbox and enter valid password
        passwordTextbox = webDriver.findElement(passwordTextboxLocator);
        passwordTextbox.sendKeys(password);

        //Identify login button and click on the button
        loginButton = webDriver.findElement(loginButtonLocator);
        loginButton.click();
    }
}
