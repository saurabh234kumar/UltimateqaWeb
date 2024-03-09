Feature: verify html table with no id

  Scenario: first letter of each word in the title is in upper case excluding the preposition
    Given I launch the application
    When I get all the title from the table with no id
    Then the first letter of each word in the title is in upper case excluding the preposition

  Scenario: all roles have at least $100k
    Given I launch the application
    When I get all the salaries from the table with no id
    Then all roles have at least $100000

  Scenario: verify there is no manual work.
    Given I launch the application
    When  get all the roles from the table with no id
    Then verify if there is any manual work
