package StepDefinitions;

import Pages.EmployeePage;
import Pages.HomePage;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeTestsStepdefs extends CommonDriver {
    HomePage homePageObject = new HomePage();
    EmployeePage empPageObject = new EmployeePage();

    @Before
    public void SetUpBrowser() {
        webDriver = new ChromeDriver();
    }

    @After
    public void CloseTestRun() {
        webDriver.quit();
    }

    @When("I navigate to Employee page")
    public void iNavigateToEmployeePage() {
        homePageObject.NavigateToEmployeePage(webDriver);
    }

    @Then("I should be able to create an Employee successfully")
    public void iShouldBeAbleToCreateAnEmployeeSuccessfully() {
        empPageObject.CreateEmployeeRecord(webDriver);
    }

    @Then("I should be able to update an Employee successfully")
    public void iShouldBeAbleToUpdateAnEmployeeSuccessfully() {
        empPageObject.EditEmployeeRecord(webDriver);
    }

    @Then("I should be able to delete an Employee successfully")
    public void iShouldBeAbleToDeleteAnEmployeeSuccessfully() {
        empPageObject.DeleteEmployeeRecord(webDriver);
    }
}
