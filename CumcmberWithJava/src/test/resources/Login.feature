Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully
@LoginScenario
  Scenario Outline: Login Successful

    Given I am in the login page of the Para Bank Application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the Overview page

  Examples:
    |username|password|userFullName|
    |"alaawahba13"|"password"|"Alaa Wahba"|
    |"tautester"|"password"|"TAU Tester"|