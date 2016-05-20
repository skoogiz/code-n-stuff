Feature: Dice

  Scenario: roll a 6 sided dice
    Given I have a dice with 6 sides
    When I roll a dice to generate a random value
    Then I get a value between 1 and 6
    And I can retrieve the current value
    
  Scenario: roll a 20 sided dice
    Given I have a dice with 20 sides
    When I roll a dice to generate a random value
    Then I get a value between 1 and 20
    And I can retrieve the current value