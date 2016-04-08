package com.skoogiz.bestiary.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testCalculate() {
			
		int firstValue = 2;
		int secondValue = 2;

		Operation operation = Operation.PLUS;

		assertEquals(firstValue + secondValue,
				operation.calculate(firstValue, secondValue));

		operation = Operation.MINUS;

		assertEquals(firstValue - secondValue,
				operation.calculate(firstValue, secondValue));

		operation = Operation.TIMES;

		assertEquals(firstValue * secondValue,
				operation.calculate(firstValue, secondValue));

		operation = Operation.OBELUS;

		assertEquals(firstValue / secondValue,
				operation.calculate(firstValue, secondValue));
	}

	@Test
	public void testCalculateValues() {
		
		int firstValue = 2;
		int secondValue = 2;

		Operation operation = Operation.PLUS;

		assertEquals(firstValue + secondValue,
				operation.calculateValues(firstValue, secondValue));

		operation = Operation.MINUS;

		assertEquals(firstValue - secondValue,
				operation.calculateValues(firstValue, secondValue));

		operation = Operation.TIMES;

		assertEquals(firstValue * secondValue,
				operation.calculateValues(firstValue, secondValue));

		operation = Operation.OBELUS;

		assertEquals(firstValue / secondValue,
				operation.calculateValues(firstValue, secondValue));
		
		int thierdValue = 2;

		operation = Operation.PLUS;

		assertEquals(firstValue + secondValue + thierdValue,
				operation.calculateValues(firstValue, secondValue, thierdValue));

		operation = Operation.MINUS;

		assertEquals(firstValue - secondValue - thierdValue,
				operation.calculateValues(firstValue, secondValue, thierdValue));

		operation = Operation.TIMES;

		assertEquals(firstValue * secondValue * thierdValue,
				operation.calculateValues(firstValue, secondValue, thierdValue));

		operation = Operation.OBELUS;

		assertEquals(firstValue / secondValue / thierdValue,
				operation.calculateValues(firstValue, secondValue, thierdValue));
	}

}
