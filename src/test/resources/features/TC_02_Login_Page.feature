Feature: Check functionality login page feature

  Scenario: User able to login by valid credentials
    Given A user must visit in Homepage
    When A user enters by valid username and password
    Then Verify that user logged in successfully