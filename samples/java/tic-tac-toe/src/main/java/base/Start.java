package base;

import view.Board;
import view.ConsoleUI;
import controller.Manager;

public class Start {

	private Manager manager = Manager.getInstance();

	public void runConsole() {
		new ConsoleUI(manager.newGame("Larry", "Berry")).start();
	}

	public void runGui() {
		new Board();
	}

	public static void main(String[] args) {
		new Start().runGui();
		// new Start().runConsole();
	}

}
