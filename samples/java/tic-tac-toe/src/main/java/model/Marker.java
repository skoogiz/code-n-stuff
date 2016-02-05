package model;

public enum Marker {

	O, X;
	
	public char toChar() {
		return name().charAt(0);
	}
	
}
