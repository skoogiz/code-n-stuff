package com.skoogiz.bestiary.model;

/**
 * 
 * Representation of an mathematical operation.
 * 
 * @author ask
 *
 */
public enum Operation {

	PLUS('+'), MINUS('-'), TIMES('*'), OBELUS('/');

	private char op;

	private Operation(char op) {
		this.op = op;
	}

	public int calculate(int firstValue, int secondValue) {
		int value = 0;

		switch (this) {
		case PLUS:
			value = firstValue + secondValue;
			break;
		case MINUS:
			value = firstValue - secondValue;
			break;
		case TIMES:
			value = firstValue * secondValue;
			break;
		case OBELUS:
			value = firstValue / secondValue;
			break;
		}

		return value;
	}

	public int calculateValues(int... values) {
		Integer value = null;

		if (values != null) {
			for (int val : values) {
				if (value == null) {
					value = val;
				} else {
					value = calculate(value, val);
				}
			}
		}

		return value;
	}

	public char asChar() {
		return op;
	}

	/**
	 * Check if operation has an representation and return {@link Operation}.
	 * 
	 * @param char representation of an operation
	 *
	 * @return matching {@link Operation}, default value is PLUS
	 */
	public static Operation getOperation(char operation) {
		for (Operation o : Operation.values()) {
			if (o.asChar() == operation) {
				return o;
			}
		}
		return PLUS;
	}
}
