Feature: Monster Book

  Scenario: create a monster template
    Given a character of the race Wood Elf
    And a ability formula:
      | STY | 2D6+3 |
      | STO | 2D4+6 |
      | FYS | 3D6   |
      | SMI | 3D6+3 |
      | INT | 4D6   |
      | PSY | 3D6   |
      | KAR | 3D6+2 |
    And a habitat:
      | 2G |
      | 3G |
    And a rarity of Uncommon
    And a base movement on land L10
    And natural protection 0
    And they usually show up in numbers 1-20
    When create monster template
    Then a monster template is created

  Scenario: generate random monster
    Given I have a monster template
    When I generate a monster
    Then a monster is created