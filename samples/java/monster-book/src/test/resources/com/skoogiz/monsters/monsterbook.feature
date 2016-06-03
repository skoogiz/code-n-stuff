Feature: Monster Book

  Scenario: create a monster template
    Given a monster template builder exists
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
    
  Scenario Outline: generate abilities
    Given a monster template builder exists
    And set ability "<name>" with formula "<formula>"
    And build monster template
    When I generate a monster
    Then a monster is created
    And monster has ability named "<name>"
    And with a value between <min> and <max>
        
  Examples:
  	| name | formula | min  |  max  |
    | STY  |  2D6+3  |   5  |   15  |
    | STO  |  2D4+6  |   8  |   14  |
    | FYS  |  3D6    |   3  |   18  |
    | SMI  |  3D6+3  |   6  |   21  |
    | INT  |  4D6    |   4  |   24  |
    | PSY  |  3D6    |   3  |   18  |
    | KAR  |  3D6+2  |   4  |   20  |