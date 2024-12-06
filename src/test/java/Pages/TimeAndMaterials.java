package Pages;

import Utilities.TM_XPaths;
import Utilities.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimeAndMaterials {

    public void CreateTimeRecord(WebDriver driver) throws InterruptedException {
        // WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));

        // Click on Create New Button
        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNewButton.click();

        // Click on the drop-down triangle icon to see Type Code drop down values
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropdown.click();

        Wait.waitToBeVisible(driver, "XPATH", TM_XPaths.typeCode, 5);
        // Applying Selenium Wait
        WebElement timeOption = driver.findElement(By.xpath(TM_XPaths.typeCode));
        // Choose Time as an option for the Type Code
        timeOption.click();

        // Write Code in the Code text box
        WebElement codeTextBox = driver.findElement(By.id("Code"));
        codeTextBox.sendKeys("N-1");

        // Write description in the text box
        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.sendKeys("N-1-Description");

        // Click the text box to allow entering price in it as the element with id price was not interactable as per selenium exception thrown
        WebElement priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();

        // Write value for Price in the text box
        WebElement pricePerUnit = driver.findElement(By.id("Price"));
        pricePerUnit.sendKeys("20");

        Thread.sleep(3000);

        // Click on Save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

        Thread.sleep(5000);

      //  Wait.waitToBeVisible(driver, "XPATH", TM_XPaths.lastPage, 5);
        // Go to the last page of the grid and wait until the element is visible
        WebElement goToLastPage = driver.findElement(By.xpath(TM_XPaths.lastPage));
        goToLastPage.click();
    }

    public String GetCode(WebDriver driver)
    {
        WebElement newCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newCode.getText();
    }

    public String GetDescription(WebDriver driver)
    {
        WebElement newDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return newDescription.getText();
    }

    public String GetPrice(WebDriver driver)
    {
        WebElement newPrice = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[4]"));
        return newPrice.getText();
    }

    public String GetEditedCode(WebDriver driver)
    {
        WebElement editedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return editedCode.getText();
    }

    public String GetEditedDescription(WebDriver driver)
    {
        WebElement editedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return editedDescription.getText();
    }

    public void EditTimeRecord(WebDriver driver, String code, String description) throws InterruptedException {
        Thread.sleep(2000);
        // WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
       // Wait.waitToBeVisible(driver, "XPATH", TM_XPaths.lastPage, 3);
        // Go to the last page of the grid and wait until element is loaded
        WebElement navigateToLastPage = driver.findElement(By.xpath(TM_XPaths.lastPage));
        navigateToLastPage.click();

        // IWebElement navigateToLastRecord = driver.FindElement(By.XPath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));

        // Edit new record
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();

        // Select the triangle icon of the Type code drop down
        WebElement typeCodeDropDown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropDown.click();
Thread.sleep(5000);
        // Applying Selenium Wait
      //  Wait.waitToBeVisible(driver, "XPATH", TM_XPaths.materialDropDown, 3);
        WebElement materialSelection = driver.findElement(By.xpath(TM_XPaths.materialDropDown));

        // Change the value of the drop down to Material
        materialSelection.click();

        // Edit the Code
        WebElement editCodeTextBox = driver.findElement(By.id("Code"));
        editCodeTextBox.clear();
        editCodeTextBox.sendKeys(code);

        // Edit description
        WebElement editDescription = driver.findElement(By.id("Description"));
        editDescription.clear();
        editDescription.sendKeys(description);

        // Click on Edit Price Text Box
        WebElement clickPriceOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        clickPriceOverlap.click();

        // Now Edit the price
        WebElement editPrice = driver.findElement(By.id("Price"));
        editPrice.clear();

        clickPriceOverlap.click();

        // Now Edit the price
        WebElement editPrice2 = driver.findElement(By.id("Price"));
        editPrice2.sendKeys("40");

        Thread.sleep(3000);

        // Click on Save Button
        WebElement clickSaveButton = driver.findElement(By.id("SaveButton"));
        clickSaveButton.click();
Thread.sleep(3000);
        // Go to the last page of the grid and wait until element is loaded
      //  Wait.waitToBeVisible(driver, "XPATH", TM_XPaths.lastPage, 2);
        WebElement goToLastPage = driver.findElement(By.xpath(TM_XPaths.lastPage));
        goToLastPage.click();

        // IWebElement getLastRecord = driver.FindElement(By.XPath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));

        //Assert.That(getLastRecord.Text == "Edited N-1", "Time record not updated successfully. Test Failed");
    }

    public void DeleteTimeRecord(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        //  WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));

        // Go to the last page of the grid and wait until element is loaded
        Wait.waitToBeVisible(driver, "XPATH", TM_XPaths.lastPage, 3);
        WebElement navigateToLastPage = driver.findElement(By.xpath(TM_XPaths.lastPage));
        navigateToLastPage.click();

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();

        // Applying Selenium Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
try{
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Handle the alert (Click OK)
        alert.accept();
    } catch (Exception e) {
        System.out.println("No alert found.");
    }
//        Thread.sleep(1000);
//        WebElement moveToLastRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));

        //Assert.That(moveToLastRecord.Text != "Edited N-1", "Time record is not deleted successfully. Test Failed");

        // Thread.Sleep(1000);
    }
}
