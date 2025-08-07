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
