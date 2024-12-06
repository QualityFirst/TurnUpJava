package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public void LoginActions(WebDriver driver) throws InterruptedException {
        // Launch TurnUp Portal
        driver.navigate().to("http://horse.industryconnect.io/");

        //Maximize the browser window
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Identify username text box and enter valid user name
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("hari");

        // Identify password textbox and enter valid password
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("123123");

        // Identify login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
        loginButton.click();
        Thread.sleep(1000);
    }
}
