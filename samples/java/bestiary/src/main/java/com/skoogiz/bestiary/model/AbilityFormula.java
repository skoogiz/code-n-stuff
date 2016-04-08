package com.skoogiz.bestiary.model;

import static com.skoogiz.bestiary.Constants.DICE_FORMULA_PATTERN;
import static com.skoogiz.bestiary.Constants.DICE_PATTERN;
import static com.skoogiz.bestiary.Constants.OPERATION_PATTERN;
import static com.skoogiz.bestiary.Constants.SIMPLE_DICE_FORMULA_PATTERN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Class for generation of ability values out of an given dice formula.
 * 
 * @author ask
 *
 */
public class AbilityFormula {

	private final String baseFormula;
	
	private final Dice[] dices;

	private Operation modifierOperation = Operation.PLUS;

	private int modifierValue = 0;

	public AbilityFormula(String formula) {
		this.baseFormula = formula.replaceAll(" ", "");
		if (baseFormula != null && baseFormula.matches(DICE_FORMULA_PATTERN)) {

			Pattern pattern = Pattern.compile(OPERATION_PATTERN);
			Matcher matcher = pattern.matcher(baseFormula);

			String diceFormula = baseFormula;

			if (matcher.find()) {

				int operationIndex = matcher.start();

				diceFormula = diceFormula.substring(0, operationIndex);

				this.modifierOperation = Operation.getOperation(baseFormula
						.charAt(operationIndex));
				this.modifierValue = Integer.parseInt(baseFormula
						.substring(operationIndex + 1));
			}

			this.dices = parseDices(diceFormula);

		} else {
			throw new IllegalArgumentException();
		}
	}

	public Dice[] parseDices(String dicesFormula) {

		Dice[] parsedDices = new Dice[0];

		if (dicesFormula.matches(SIMPLE_DICE_FORMULA_PATTERN)) {
			String[] values = dicesFormula.split(DICE_PATTERN);
			parsedDices = new Dice[Integer.parseInt(values[0])];
			int size = Integer.parseInt(values[1]);
			for (int i = 0; i < parsedDices.length; i++) {
				parsedDices[i] = new Dice(size);
			}
		}

		return parsedDices;
	}

	@Override
	public String toString() {
		return baseFormula;
	}
	
	/**
	 * Generate a value based on the given formula.
	 * 
	 * @return
	 */
	public int generateValue() {
		int value = 0;

		for (Dice dice : dices) {
			dice.roll();
			value += dice.getCurrentValue();
		}

		if (modifierValue > 0) {
			value = modifierOperation.calculate(value, modifierValue);
		}

		return value;
	}
}
