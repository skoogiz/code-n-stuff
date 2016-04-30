Feature: Monster Book

  Scenario: generate random monster
    Given I have a monster template
    When I generate a monster
    Then a monster is created