/**
 * 
 */
package com.skoogiz.monsters;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
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

    private Monster monster;

    @Given("^I have a monster template$")
    public void i_have_a_monster_template()
    {
        template = new MonsterTemplate.Builder().build();

        assertNotNull(template);
    }

    @When("^I generate a monster$")
    public void i_generate_a_monster()
    {
        monster = template.generate();
    }

    @Then("^a monster is created$")
    public void a_monster_is_created()
    {
        assertThat("That we have spawned a Monster", monster, notNullValue());
    }
}
