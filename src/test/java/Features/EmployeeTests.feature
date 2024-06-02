Feature: Employee Management
  As a user of TurnUp Portal
  I want to manage employees
  So that I can add, update, and delete employee records

  Background:
    Given I logged into turnup portal successfully
    When I navigate to time and material page

  Scenario: Create an Employee
    Then I should be able to create an Employee successfully

  Scenario: Update an Employee
    Then I should be able to update an Employee successfully

  Scenario: Delete an Employee
    Then I should be able to delete an Employee successfully