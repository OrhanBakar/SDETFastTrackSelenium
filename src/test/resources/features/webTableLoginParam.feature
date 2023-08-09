Feature: Web-table app login
  User Story: User should be able to login web-table application
  @webTableParam
  Scenario: Login Web-table app with parameters

    Given user is on the login page of the webtable app
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains order
    @webTable2Param
    Scenario: Login with 2 params
      Given user is on the login page of the webtable app
      When user enters username "Test" password "Tester" and logins
      Then user should see url contains order