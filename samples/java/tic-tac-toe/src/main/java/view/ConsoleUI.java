package view;

import java.util.Scanner;

import model.Game;
import model.Grid;
import model.Player;

public class ConsoleUI {

	private Game game;

	private Scanner scanner = new Scanner(System.in);
	
	public ConsoleUI(Game game) {
		this.game = game;
	}

	public void welcome() {
		System.out.println("* * * * * * * * * * * * * * * * *");
		System.out.println(" Welcome players!");
		for (int i = 0; i < game.getPlayers().length; i++) {
			System.out.printf(" Players #%d : %s%n", i + 1,
					game.getPlayers()[i].getName());
		}
		System.out.println("* * * * * * * * * * * * * * * * *");
	}

	public void print() {
		// for(int i = 0; i < table.length; i++) {
		// char[] row = table[i];
		for (Character[] row : game.getGrid().getTable()) {
			for (int r = 0; r < row.length; r++) {
				Character square = row[r];
				// System.out.print(sq == null ? "-" : sq);
				if (square == null) {
					System.out.print("-");
				} else {
					System.out.print(square);
				}
			}
			System.out.println();
		}
	}

	public boolean takeTurn(Player player) {
		Grid grid = game.getGrid();
		boolean validMove = false;
		System.out.println(player.getName() + " make your move!");
		do {
			System.out.print("Enter row cordinate: ");
			int row = scanner.nextInt();
			System.out.print("Enter column cordinate: ");
			int col = scanner.nextInt();
			try {
				validMove = grid.makeMove(player.getMarkerAsChar(), row, col);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				validMove = false;
				System.out.println("Please try again!");
			}
		} while (!validMove);
		print();

		return grid.validate(player.getMarkerAsChar());
	}

	public void start() {

		welcome();

		boolean gamesOn = true;

		Player[] players = game.getPlayers();

		while (gamesOn) {
			for (Player player : players) {
				gamesOn = !takeTurn(player);
				if (!gamesOn) {
					System.out.println(player.getName() + " wins the game!!!");
					break;
				}
			}
		}

	}

}
