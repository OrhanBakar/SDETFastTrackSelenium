
@smoke
Feature: WebTable app login

  User Story: User should be able to login webtable application with valid credentials

  Background:
    Given user is on the login page of the webtable app
@smoke @webTableLogin
  Scenario: Login scenario

    When user enters username Test
    And user enters password Tester
    And user clicks to login button
    Then user should see url contains order
  @wip
  Scenario: Login scenario
    When user enters invalid username
    And user enters invalid password
    And user clicks to login button
    Then user should see url contains login