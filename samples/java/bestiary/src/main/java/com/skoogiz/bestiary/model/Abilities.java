/**
 * 
 */
package com.skoogiz.bestiary.model;

/**
 * @author ask
 *
 */
public final class Abilities {

	public static Ability getAbility(String name, AbilityFormula formula)
			throws IllegalArgumentException {

		return new Ability(name, formula.generateValue(), formula.toString());

	}
	
	public static Ability getAbility(String name, String formula)
			throws IllegalArgumentException {

		return getAbility(name, new AbilityFormula(formula));

	}

	private Abilities() {
	}
}
