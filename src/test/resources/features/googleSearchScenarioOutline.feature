Feature: Google Search
@googleSearch
  Scenario Outline: Google search for capital citiy of different countries
    Given user is on  google home page
    When user searches for "<country>" capital
    Then user should see the "<capital>" result
    Examples:
      | country | capital           |
      | USA     | Waschington, D.C. |
      | Turkey  | Ankara            |
      | Germany | Berlin            |
      | France  | Paris             |

