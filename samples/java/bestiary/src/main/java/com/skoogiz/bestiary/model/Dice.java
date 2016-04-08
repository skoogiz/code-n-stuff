package com.skoogiz.bestiary.model;

import java.util.Random;

/**
 * 
 * Class representation of a dice.
 * 
 * @author ask
 *
 */
public class Dice {

	private final int sides;

	private int currentValue;

	private Random random = new Random();

	public Dice() {
		this.sides = 6;
		roll();
	}

	public Dice(int sides) {
		this.sides = sides;
		roll();
	}

	public String getName() {
		return "D" + sides;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public int roll() {
		this.currentValue = random.nextInt(sides) + 1;
		return getCurrentValue();
	}
}
