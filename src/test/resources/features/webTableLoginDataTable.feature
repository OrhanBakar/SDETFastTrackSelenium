Feature: Web-table app login with data table
  User Story: User should be able to login web-table application
@webTableLoginDataTable
  Scenario: login webtable app with datatable
    Given user is on the login page of the webtable app
    When user enters the credentials below
      | username | Test   |
      | password | Tester |
    Then user should see url contains order


