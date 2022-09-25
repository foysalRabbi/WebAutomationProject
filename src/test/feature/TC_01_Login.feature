
@LoginTestCase
Feature: Check login functionality in nopStation

  Scenario: Verify that a user is able to login successfully by valid credentials in nopStation
    Given A user must visit at homepage through the desired URL
    When A user enters a valid username in username field
    And A user enters a valid password in password field
    And A user click on submit button
    Then A user is able to view a redirect page



