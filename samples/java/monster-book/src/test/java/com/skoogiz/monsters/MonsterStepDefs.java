/**
 * 
 */
package com.skoogiz.monsters;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

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

    private MonsterTemplate.Builder builder;

    @Given("^a monster template builder$")
    public void a_monster_template_builder() throws Throwable
    {
        builder = new Builder();
    }

    @When("^set race \"([^\"]*)\"$")
    public void set_race(String race) throws Throwable
    {
        builder.race(race);
    }

    @When("^set abilities:$")
    public void set_abilities(Map<String, String> abilities) throws Throwable
    {
        abilities.forEach((name, formula) -> builder.ability(name, formula));
    }

    @When("^set habitats:$")
    public void set_habitats(List<String> habitats) throws Throwable
    {
        habitats.forEach((habitat) -> builder.habitat(habitat));
    }

    @When("^set rarity \"([^\"]*)\"$")
    public void set_rarity(String rarity) throws Throwable
    {
        builder.rarity(rarity);
    }

    @When("^set movement on land \"([^\"]*)\"$")
    public void set_movement_on_land(String movement) throws Throwable
    {
        builder.movement(movement);
    }

    @When("^set natural protection \"(\\d+)\"$")
    public void set_natural_protection(int protection) throws Throwable
    {
        builder.protection(protection);
    }

    @When("^set numbers they show up in \"([^\"]*)\"$")
    public void set_numbers_they_show_up_in(String numbers) throws Throwable
    {
        builder.numbers(numbers);
    }

    @When("^build monster template$")
    public void build_monster_template() throws Throwable
    {
        template = builder.build();

    }

    @Then("^a monster template is created$")
    public void a_monster_template_is_created() throws Throwable
    {
        assertThat("template exists", template, is(notNullValue()));
    }

}
