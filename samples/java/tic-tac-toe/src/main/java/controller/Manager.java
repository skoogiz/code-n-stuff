package controller;

import model.Game;
import model.Grid;
import model.Player;

public class Manager {
	
	public static final Manager INSTANCE = new Manager();

	private Manager() {
	}

	public static Manager getInstance() {
		return INSTANCE;
	}

	public Game newGame(String name1, String name2) {
		return new Game(name1, name2);
	}
	
	public void makeMove(Player player, Grid grid, int x, int y) throws Exception {
		grid.makeMove(player.getMarkerAsChar(), x, y);
	}
	
	public boolean isCurrentPlayerWinner(Game game) {
		return game.getGrid().validate(game.getCurrentPlayer().getMarkerAsChar());
	}
	
	// public Move(Player, )
}
