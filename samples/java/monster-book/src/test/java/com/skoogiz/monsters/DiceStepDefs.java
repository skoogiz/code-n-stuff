/**
 * 
 */
package com.skoogiz.monsters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.skoogiz.monsters.dice.Dice;
import com.skoogiz.monsters.dice.DiceFormula;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author ask
 *
 */
public class DiceStepDefs
{

    private Dice dice;

    private DiceFormula formula;

    private int currentNumber;

    @Given("^I have a dice with (\\d+) sides$")
    public void i_have_a_dice_with_sides(int sides)
    {
        dice = new Dice(sides);

        assertThat("dice has the right number of sides", dice.getSides(), is(sides));
    }

    @When("^I roll a dice to generate a random value$")
    public void i_roll_a_dice_to_generate_a_random_value() throws Throwable
    {
        currentNumber = dice.roll();

        assertNotNull(currentNumber);
    }

    @Then("^I get a value between (\\d+) and (\\d+)$")
    public void i_get_a_value_between_and(int min, int max)
    {
        assertThat(String.format("current number '%d' is between '%d' and '%d",
            currentNumber, min, max), true, is(currentNumber >= min && currentNumber <= max));
    }

    @Then("^I can retrieve the current value$")
    public void i_can_retrieve_the_current_value() throws Throwable
    {
        assertEquals(currentNumber, dice.getCurrentValue());
    }

    @Given("^a dice formula \"(.+)\"$")
    public void a_dice_formula(String formula) throws Throwable
    {
        this.formula = DiceFormula.parse(formula);
    }

    @When("^generating a random value$")
    public void generating_a_random_value() throws Throwable
    {
        currentNumber = formula.generate();

    }
}
