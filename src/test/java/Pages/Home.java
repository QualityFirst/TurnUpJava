package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    public void NavigateToTMPage(WebDriver driver)
    {
        // Click on Administration Menu
        WebElement administrationTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a/span"));
        administrationTab.click();

        // Click on Time and Materials Sub-Menu
        WebElement timeAndMaterialOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
        timeAndMaterialOption.click();
    }

    public void NavigateToCustomersPage(WebDriver driver)
    {
        // Click on Administration Menu
        WebElement adminTab = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a/span"));
        adminTab.click();

        // Click on Customers Sub-Menu
        WebElement customersOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[1]/a"));
        customersOption.click();
    }
}
