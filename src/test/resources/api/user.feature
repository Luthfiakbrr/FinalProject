<<<<<<< HEAD
Feature: API Testing for User Endpoint

  @api @get
  Scenario: Get a user by ID
    Given I set GET endpoint for user with ID "60d0fe4f5311236168a109ca"
    When I send GET HTTP request
    Then I receive valid HTTP response code 200
    And Response body should contain user ID "60d0fe4f5311236168a109ca"

  Scenario: Create new user with valid data
    Given I set POST endpoint for creating user
    When I send POST HTTP request with valid data
    Then I receive valid HTTP response code 200
    And Response body should contain the created user's name

  Scenario: Create user with invalid data
    Given I set POST endpoint for creating user
    When I send POST HTTP request with missing required fields
    Then I receive HTTP response code 400

  Scenario: Get user with invalid ID
    Given I set GET endpoint for user with ID "invalid-id"
    When I send GET HTTP request
    Then I receive HTTP response code 400

  Scenario: Delete a user
    Given I set DELETE endpoint for user with ID "60d0fe4f5311236168a109ca"
    When I send DELETE HTTP request
    Then I receive valid HTTP response code 200
=======
@api
Feature: User API tests using DummyAPI

  @get @positive
  Scenario: Get user by valid ID
    When I send a POST request to "/user/create" with valid user data
    Then the response status should be 200
    When I send a GET request to "/user/{createdUserId}"
    Then the response status should be 200
    And response body should contain "id"

  @get @negative
  Scenario: Get user by invalid ID
    When I send a GET request to "/user/invalid-id"
    Then the response status should be 400

  @post @positive
  Scenario: Create new user with valid data
    When I send a POST request to "/user/create" with valid user data
    Then the response status should be 200
    And response body should contain created user details

  @put @positive
  Scenario: Update an existing user
    When I send a POST request to "/user/create" with valid user data
    Then the response status should be 200
    When I send a PUT request to update the user
    Then the response status should be 200
    And response should reflect updated fields

  @delete @positive
  Scenario: Delete an existing user
    When I send a POST request to "/user/create" with valid user data
    Then the response status should be 200
    When I send a DELETE request to delete the user
    Then the response status should be 200

  @e2e
  Scenario: End-to-end create, update, and delete user
    When I send a POST request to "/user/create" with valid user data
    Then the response status should be 200
    And response body should contain created user details
    When I send a PUT request to update the user
    Then the response status should be 200
    And response should reflect updated fields
    When I send a DELETE request to delete the user
    Then the response status should be 200
>>>>>>> 27c271d (push Feedback)
