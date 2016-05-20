Feature: Dice

  Scenario Outline: roll a dice
    Given I have a dice with <sides> sides
    When I roll a dice to generate a random value
    Then I get a value between <min> and <max>
    And I can retrieve the current value
    
  Examples:
    | sides |  min  |  max  |
    |     6 |     1 |     6 |
    |     8 |     1 |     8 |
    |    10 |     1 |    10 |
    |    12 |     1 |    12 |
    |    20 |     1 |    20 |
    |   100 |     1 |   100 |
    