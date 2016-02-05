package model;

import java.util.Observable;

public class Game extends Observable {

	private final Player player1;
	
	private final Player player2;
	
	private final Grid grid = new Grid(3, 3);

	private Player currentPlayer; 
	
	public Game(String firstPlayerName, String secondPlayerName) {
		super();
		this.player1 = new Player(firstPlayerName, Marker.X);
		this.player2 = new Player(secondPlayerName, Marker.O);
		this.currentPlayer = player1;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void togglePlayer() {
		if (currentPlayer.equals(player1)) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
		setChanged();
		notifyObservers();
	}

	public Grid getGrid() {
		return grid;
	}
	
	public Player[] getPlayers() {
		return new Player[] {player1, player2};
	}
	
}
