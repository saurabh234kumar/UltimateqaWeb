Feature: Email subscribe for 10 different users

  Scenario Outline: Email Me!
    Given I launch the application
    Then I enter username as <name> and email address as <email>
    When I submit
    Then I should see "Thanks for contacting us"
    Examples:
      | name     | email             |
      | "test1"  | "test1@test.com"  |
      | "test2"  | "test2@test.com"  |
      | "test3"  | "test3@test.com"  |
      | "test4"  | "test4@test.com"  |
      | "test5"  | "test5@test.com"  |
      | "test6"  | "test6@test.com"  |
      | "test7"  | "test7@test.com"  |
      | "test8"  | "test8@test.com"  |
      | "test9"  | "test9@test.com"  |
      | "test10" | "test10@test.com" |
