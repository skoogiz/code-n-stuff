Feature: Monster Book

  Scenario: create a monster template
    Given a monster template builder
    When set race "Wood Elf"
    And set abilities:
      | STY | 2D6+3 |
      | STO | 2D4+6 |
      | FYS | 3D6   |
      | SMI | 3D6+3 |
      | INT | 4D6   |
      | PSY | 3D6   |
      | KAR | 3D6+2 |
    And set habitats:
      | 2G |
      | 3G |
    And set rarity "Uncommon"
    And set movement on land "L10"
    And set natural protection "0"
    And set numbers they show up in "1-20" 
    And build monster template
    Then a monster template is created

  Scenario: generate random monster
    Given a monster template exists
    When I generate a monster
    Then a monster is created