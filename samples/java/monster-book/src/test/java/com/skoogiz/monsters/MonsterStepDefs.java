/**
 * 
 */
package com.skoogiz.monsters;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import com.skoogiz.monsters.logic.MonsterResolver;
import com.skoogiz.monsters.logic.TemplateResolver;
import com.skoogiz.monsters.model.Ability;
import com.skoogiz.monsters.model.Monster;
import com.skoogiz.monsters.model.MonsterTemplate;
import com.skoogiz.monsters.model.MonsterTemplate.Builder;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author ask
 *
 */
public class MonsterStepDefs
{

    private MonsterTemplate template;

    private MonsterTemplate.Builder templateBuilder;

    private Monster monster;

    private Monster.Builder monsterBuilder;

    private Ability currentAbility;

    @Given("^a monster template builder exists$")
    public void a_monster_template_builder()
    {
        templateBuilder = new Builder();
    }

    @When("^set race \"([^\"]*)\"$")
    public void set_race(String race)
    {
        templateBuilder.race(race);
    }

    @When("^set abilities:$")
    public void set_abilities(Map<String, String> abilities)
    {
        abilities.forEach((name, formula) -> templateBuilder.ability(name, formula));
    }

    @When("^set habitats:$")
    public void set_habitats(List<String> habitats)
    {
        habitats.forEach((habitat) -> templateBuilder.habitat(habitat));
    }

    @When("^set rarity \"([^\"]*)\"$")
    public void set_rarity(String rarity)
    {
        templateBuilder.rarity(rarity);
    }

    @When("^set movement on land \"([^\"]*)\"$")
    public void set_movement_on_land(String movement)
    {
        templateBuilder.movement(movement);
    }

    @When("^set natural protection \"(\\d+)\"$")
    public void set_natural_protection(int protection)
    {
        templateBuilder.protection(protection);
    }

    @When("^set numbers they show up in \"([^\"]*)\"$")
    public void set_numbers_they_show_up_in(String numbers)
    {
        templateBuilder.numbers(numbers);
    }

    @When("^build monster template$")
    public void build_monster_template()
    {
        template = templateBuilder.build();

    }

    @Then("^a monster template is created$")
    public void a_monster_template_is_created()
    {
        assertThat("template exists", template, is(notNullValue()));
        assertThat("it is a tamplete", template, isA(MonsterTemplate.class));
    }

    @Given("^a monster template exists$")
    public void a_monster_template_exists()
    {
        template = new Builder().build();

        assertThat("template exists", template, is(notNullValue()));
        assertThat("it is a tamplete", template, isA(MonsterTemplate.class));
    }

    @When("^I generate a monster$")
    public void i_generate_a_monster()
    {
        TemplateResolver<Monster> resolver = new MonsterResolver();
        monster = resolver.resolve(template);
    }

    @Then("^a monster is created$")
    public void a_monster_is_created()
    {
        assertThat("monster exists", monster, is(notNullValue()));
        assertThat("it is a Monster", monster, isA(Monster.class));
    }

    @When("^set ability \"(.*)\" with formula \"(.*)\"$")
    public void set_ability_with_formula(String name, String formula)
    {
        templateBuilder.ability(name, formula);
    }

    @Then("^monster has ability named \"(.*)\"$")
    public void monster_has_ability_named(String name) throws Throwable
    {
        currentAbility = monster.getAbility(name);

        assertThat(name + " is an Ability", currentAbility, isA(Ability.class));
    }

    @Then("^with a value between (\\d+) and (\\d+)$")
    public void with_a_value_between_and(int min, int max)
    {

        assertThat(String.format("Abiility value '%d' is between '%d' and '%d",
            currentAbility.getValue(), min, max), true, is(currentAbility.getValue() >= min &&
            currentAbility.getValue() <= max));
    }

    @Then("^monster is a \"(.*)\"$")
    public void monster_is_a(String race)
    {
        assertThat("monster is a '" + race + "'", monster.getRace(), is(race));
    }
}
