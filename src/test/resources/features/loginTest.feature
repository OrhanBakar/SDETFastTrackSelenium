Feature: First Cucumber Test

  Scenario: As a user I should be able to login

    Given user goes to login page
    When user enters valid credentials and click login button
    Then user should be on the dashboard
