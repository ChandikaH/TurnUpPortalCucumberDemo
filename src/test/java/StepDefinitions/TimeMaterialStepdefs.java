package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TimeMaterialPage;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeMaterialStepdefs extends CommonDriver {

    LoginPage loginPageObject = new LoginPage();
    HomePage homePageObject = new HomePage();
    TimeMaterialPage tmPageObject = new TimeMaterialPage();

    @Before
    public void SetUpBrowser() {

        // Launch Chrome browser
        webDriver = new ChromeDriver();
    }

    @After
    public void CloseTestRun() {
        webDriver.quit();
    }

    @Given("I logged into turnup portal successfully")
    public void iLoggedIntoTurnupPortalSuccessfully() {
        loginPageObject.LoginActions(webDriver, "hari", "123123");
    }

    @When("I navigate to time and material page")
    public void iNavigateToTimeAndMaterialPage() {
        homePageObject.NavigateToTimeMaterialPage(webDriver);
    }

    @And("I create a new time and material record {string} {string} {string} {string}")
    public void iCreateANewTimeAndMaterialRecord(String code, String typeCode, String description, String price) {
        tmPageObject.CreateTimeRecord(webDriver, code, typeCode, description, price);
    }

    @Then("The record should be created successfully {string} {string} {string} {string}")
    public void theRecordShouldBeCreatedSuccessfully(String code, String typeCode, String description, String price) {
        tmPageObject.CreateTMAssertion(webDriver, code, typeCode, description, price);
    }

    @And("I edit an existing time and material record {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iEditAnExistingTimeAndMaterialRecord(String oldCode, String oldTypeCode, String oldDescription, String oldPrice, String newCode, String newTypeCode, String newDescription, String newPrice) {
        tmPageObject.EditTMRecord(webDriver, oldCode, oldTypeCode, oldDescription, oldPrice, newCode, newTypeCode, newDescription, newPrice);
    }

    @Then("The record should be updated successfully {string} {string} {string} {string}")
    public void theRecordShouldBeUpdatedSuccessfully(String newCode, String newTypeCode, String newDescription, String newPrice) {
        tmPageObject.EditTMAssertion(webDriver, newCode, newTypeCode, newDescription, newPrice);
    }

    @And("I delete an existing time and material record")
    public void iDeleteAnExistingTimeAndMaterialRecord() {
        tmPageObject.DeleteTM(webDriver);
    }

    @Then("The record should be deleted successfully {string} {string} {string} {string}")
    public void theRecordShouldBeDeletedSuccessfully(String code, String typeCode, String description, String price) {
        tmPageObject.DeleteTMAssertion(webDriver, code, typeCode, description, price);
    }
}
