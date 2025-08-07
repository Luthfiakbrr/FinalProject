<<<<<<< HEAD
Feature: User login to Demoblaze

  @web @login
  Scenario: Successful login with valid credentials
    Given I open the Demoblaze homepage
    When I click on login button
    And I enter username "testuser" and password "test123"
    And I click on login submit button
    Then I should see user "testuser" is logged in

  Scenario: Add product to cart
    Given I open the Demoblaze homepage
    When I login as "testuser" with password "test123"
    And I add "Samsung galaxy s6" to the cart
    Then I should see confirmation message

  Scenario: Remove product from cart
    Given I am logged in as "testuser"
    When I open the cart and remove "Samsung galaxy s6"
    Then I should see the cart is empty

  Scenario: Logout
    Given I am logged in as "testuser"
    When I click on logout
    Then I should be logged out

  Scenario: End-to-end purchase flow
    Given I open the Demoblaze homepage
    When I login as "testuser" with password "test123"
    And I add "Samsung galaxy s6" to the cart
    And I place the order
    Then I should see order confirmation
=======
@web
Feature: Login Page - Demoblaze

  Scenario: Login with valid credentials
    Given I am on the login page
    When I enter valid username "testuser" and password "testpass"
    And I click on login button
    Then I should be logged in successfully

  Scenario: Login with invalid credentials
    Given I am on the login page
    When I enter valid username "testuser" and password "wrongpass"
    And I click on login button
    Then Error message should be shown

  Scenario: Navigate to Cart
    Given User is logged in
    When User clicks on Cart
    Then Cart page should be visible

  Scenario: Logout
    Given User is logged in
    When User clicks Logout
    Then User should be logged out

  @e2e
  Scenario: End-to-end Product Purchase
    Given User is logged in
    When User adds product to cart
    And User proceeds to checkout
    Then Purchase should be completed
>>>>>>> 27c271d (push Feedback)
