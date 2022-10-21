
@PlaceOrder
Feature: Check that login,Search, mini shopping cart and checkout functionality in nopStation

Background:
  Given A user must visit at homepage through the desired URL
  When A user enters a valid username in username field
  And A user enters a valid password in password field
  And A user click on submit button

  Scenario: Verify that a user is able to add in mini shopping cart successfully by valid keywords in nopStation

    When Take input a product in the search box
    And  Click search button
    When Click add to cart button
    And click add to cart button in details page


    Scenario: Verify that user is able to place an order successfully in nopStation

      When Click on checkout button in my cart page
      Then Click continue button at customer's delivery section in checkout page
      And Click continue button at shipping method section in checkout page
      And Click continue button at payment method section in checkout page
      And Click continue button at confirm order section in checkout page
      And click confirm button at confirm order section in checkout page
      Then Verify that my order placed successfully






