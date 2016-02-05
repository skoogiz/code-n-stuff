package model;
import java.util.Observable;
import java.util.Random;

public class Dice extends Observable {
	
	private final int sides;
	private int currentValue;
	private Random random = new Random();

	// default constructor
	public Dice() {
		this.sides = 6;
		roll();
	}

	// constructor
	public Dice(int sides) {
		this.sides = sides;
		roll();
	}

	// metod3
	public String getName() {
		return "D" + sides;
	}

	public int getSides() {
		return sides;
	}
	
	// hämtar rullad träning
	public int getValue() {
		return currentValue;
	}

	// rullar tärning
	public int roll() {
		currentValue = random.nextInt(sides) + 1;
		
		// Do observer stuff
		setChanged();
		notifyObservers();
		
		return getValue();
	}

}