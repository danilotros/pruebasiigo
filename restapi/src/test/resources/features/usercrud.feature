Feature: Perform CRUD operations on a user in Reqres.in API

  As an API tester
  I want to perform Create, Read, Update, and Delete operations on a user
  So that I can verify the functionality of the Reqres.in API

  Scenario: End-to-End test of user CRUD operations
    # Step 1: Create a user
    Given I create a user with the name juan and the job developer
    When the response status code is 201
    Then the response should contain the user's name juan
    And the response should contain the user's job developer

    # Step 2: Get a user
    Given  I get the user that create
    When the response status code is 200
    Then the response should contain the user's data

    # Step 3: Update a user
    Given  I update the user whit the name Juana and the job Manager
    When the response status code is 200
    Then the response should contain the user's name Juana
    And the response should contain the user's job Manager

    # Step 4: Delete a user
    Given  I delete a user
    When the response status code is 204
    Then the response body should be empty


