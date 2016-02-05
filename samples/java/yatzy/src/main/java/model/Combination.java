package model;

public enum Combination {
	ONES, TWOS, THREES, FOURS, FIVES, SIXES, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, FOUR_OF_A_KIND, SMALL_STRAIGHT, LARGE_STRAIGHT, FULL_HOUSE, CHANCE, YATZY;

	public static Combination get(int index) {
		return values()[index];
	}
	
	public static int size() {
		return values().length;
	}

}
