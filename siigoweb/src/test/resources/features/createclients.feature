Feature: test flows for client creation

  Background:
    Given the user is on the login page
    When the user login with username retoautomationsiigo@yopmail.com and password T4b4ck0ff1c3P455w0rd658*

### E2E
  Scenario: User logs in and accesses "Clients" form
    Then the user is redirected to the dashboard
    When the user select client option
    Then the Crear un tercero form is displayed

### Unit Test
  Scenario: Validate name field is not empty
    Given the Crear un tercero form is displayed
    When the user enters a name "Juan"
    Then the name is accepted
    When the user leaves the name field empty
    Then an error "Name is required" is shown

### Integration Test
  Scenario: Login and verify "Create Client" form loads
    Then the user is redirected to the dashboard
    When the user select client option
    Then the Crear un tercero form is displayed
    Then the Create Client form loads

### Acceptance Test
  Scenario: User accesses the "Create Client" form after login
    Then the Crear un tercero form is displayed
    And the form contains "Name", "LastName", "Identification"
