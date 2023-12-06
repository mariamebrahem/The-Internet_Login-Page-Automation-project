@regression


Feature: user should be able to login to the system

  Background: user open the browser and go to home page
    Given user open the browser
    And user navigates to login page

  #Test Scenario 1
  Scenario: user login with valid username and password

    When user enter "tomsmith" and "SuperSecretPassword!"
    And click on login button

    #Expected result
    Then user can login successfully
    And user go to home page


  #Test Scenario 2
  Scenario: user login with invalid username and password

    When user enter "mariam" and "password"
    And click on login button

    #Expected result
    Then user can not login successfully


