Feature: Monster Book

  Scenario: generate random monster
    Given I have a monster template
    When I generate a monster
    Then a monster is created
    
  Scenario: roll a dice
    Given I have a dice
    When I roll a dice
    Then get a random number