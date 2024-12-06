package StepDefinitions;

import Pages.Home;
import Pages.Login;
import Pages.TimeAndMaterials;
import Utilities.CommonDriver;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TMStepDefinitions extends CommonDriver {
    @Given("I logged into TurnUp portal successfully")
    public void i_logged_into_turn_up_portal_successfully() throws InterruptedException {
        // Open Chrome Browser
        driver = new ChromeDriver();

        // Login page object initialization and definition
        Login loginPageObj = new Login();
        loginPageObj.LoginActions(driver);
    }

    @When("I navigate to Time and Material page")
    public void i_navigate_to_time_and_material_page() {
        // Home page object initialization and definition
        Home homePageObj = new Home();
        homePageObj.NavigateToTMPage(driver);
    }

    @When("I create a time record")
    public void i_create_a_time_record() throws InterruptedException {
        // TM page object initialization and definition
        TimeAndMaterials tMPageObj = new TimeAndMaterials();
        tMPageObj.CreateTimeRecord(driver);
    }

    @Then("the record should be created successfully")
    public void the_record_should_be_created_successfully() {
        TimeAndMaterials tMPageObj = new TimeAndMaterials();

        String newCode = tMPageObj.GetCode(driver);
        String newDescription = tMPageObj.GetDescription(driver);
        String newPrice = tMPageObj.GetPrice(driver);
        String expectedCode = "N-1";
        String expectedDescription = "N-1-Description";
        String expectedPrice = "$20.00";
        Assert.assertEquals(newCode, expectedCode, "Actual and expected code do not match");
        Assert.assertEquals(newPrice, expectedPrice, "Expected and actual price do not match");
        Assert.assertEquals(newDescription, expectedDescription, "Actual and expected description do not match");
    }

    @When("I update the {string} and {string} on an existing Time record")
    public void iUpdateTheCodeAndDescriptionOnAnExistingTimeRecord(String code, String description) throws InterruptedException {
        TimeAndMaterials tMPageObj = new TimeAndMaterials();
        tMPageObj.EditTimeRecord(driver, code, description);
    }

    @Then("the record should have the updated {string} and {string}")
    public void theRecordShouldHaveTheUpdatedCodeAndDescription(String code, String description) {
        TimeAndMaterials tMPageObj = new TimeAndMaterials();

        String editedCode = tMPageObj.GetEditedCode(driver);
        String editedDescription = tMPageObj.GetEditedDescription(driver);

        Assert.assertEquals(editedCode, code, "Expected Edited Code and actual edited code do not match.");
        Assert.assertEquals(editedDescription, description, "Expected Edited Description and actual edited description do not match.");

    }

    @When("I delete an existing record")
    public void iDeleteAnExistingRecord() throws InterruptedException {
        // Delete Time Record
        TimeAndMaterials tMPageObj = new TimeAndMaterials();
        tMPageObj.DeleteTimeRecord(driver);
    }

    @Then("the record should not be present on the table")
    public void theRecordShouldNotBePresentOnTheTable() {
        TimeAndMaterials tMPageObj = new TimeAndMaterials();

        String editedCode = tMPageObj.GetEditedCode(driver);
        String editedDescription = tMPageObj.GetEditedDescription(driver);

        String expectedCode = "N-EditedRecord";
        String expectedDescription = "N-3-Description";
        Assert.assertEquals(editedCode, expectedCode, "Time record is not deleted successfully. Test Failed");
        Assert.assertEquals(editedDescription, expectedDescription, "Expected Edited Description and actual edited description do not match.");
    }

    @After
    public void AfterScenario() {
        // Close the browser and quit the WebDriver session
        driver.quit();
    }
}
