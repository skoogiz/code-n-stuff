package com.skoogiz.bestiary.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AbilityFormulaTest {

	private String validValueNo1 = "1t100";
	private String validValueNo2 = "2T12+2";
	private String validValueNo3 = "3 d 6";
	private String validValueNo4 = "4D4 + 1";

	private String invalidValueNo1 = "1x20";
	private String invalidValueNo2 = "1D8+ +6";

	@Test
	public void testConstructorOnce() {

		List<AbilityFormula> formulas = Arrays.asList(
				new AbilityFormula(validValueNo1), 
				new AbilityFormula(validValueNo2),
				new AbilityFormula(validValueNo3), 
				new AbilityFormula(validValueNo4));

		for (AbilityFormula abilityFormula : formulas) {
			System.out.printf("Formula for '%s'%n", abilityFormula.toString());
			assertNotNull(abilityFormula);
			assertTrue(abilityFormula instanceof AbilityFormula);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorToFailOnce() {
		new AbilityFormula(invalidValueNo1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorToFailTwice() {
		new AbilityFormula(invalidValueNo2);
	}

	@Test
	public void testGenerateValueOnce() {
		String dices = "3T6+1";
		
		AbilityFormula formula = new AbilityFormula(dices);
		assertNotNull(formula);
		
		int value = formula.generateValue();
		assertTrue(String.format("'%d' is a vlaue between 4 and 19", value), 3 < value && 20 > value);
	}

}
