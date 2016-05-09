/**
 * 
 */
package com.skoogiz.monsters;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author ask
 *
 */
public class MonsterStepDefs {

	private Dice dice;

	private int currentNumber;
	
	@Given("^I have a dice with (\\d+) sides$")
	public void i_have_a_dice_with_sides(int sides) {
		
		dice = new Dice(sides);
	
		assertEquals(sides, dice.getSides());
	}
	
	@When("^I roll a dice to generate a random value$")
	public void i_roll_a_dice_to_generate_a_random_value() throws Throwable {
		
		currentNumber = dice.roll();
		
		assertNotNull(currentNumber);
		
	}

	@Then("^I get a value between (\\d+) and (\\d+)$")
	public void i_get_a_value_between_and(int min, int max) {
		
		assertTrue(currentNumber >= min && currentNumber <= max);
		
	}
	
	@Then("^I can retrieve the current value$")
	public void i_can_retrieve_the_current_value() throws Throwable {
	    
		assertEquals(currentNumber, dice.getCurrentValue());
		
	}
	
}
