Feature: VyTrack Login

  Scenario: Login as driver

    Given user goes to vytrack login page
    When user enters username and password and click login button
    Then user is on the dashboard