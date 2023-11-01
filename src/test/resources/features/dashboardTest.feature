@wip
Feature: Validate if navigation bar is visible

Background:
  Given user goes to vytrack login page

  Scenario: Validate navigation bar

    When user enters username and password and click login button
    Then user should be able to see options

      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  Scenario Outline: Login with different Role
    When user choose "<role>"

    Then user should be able to see options printed
    Examples:
      | role  |
      | Sales |
      | Store |