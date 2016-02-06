package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.Combination;
import model.Dice;
import model.Game;
import model.Player;

public class RollDiceView extends JFrame {

	// Swing grafik
	private JPanel mainPanel;
	private JPanel dicePanel;
	private JPanel buttonPanel;
	private JButton rollButton;

	private JPanel gamePanel;

	// Model för spelet
	private Game game;

	
	
	// View för tärning
	private List<DiceImage> diceImages = new ArrayList<DiceImage>();

	public RollDiceView() {
		createAndShowGui();
	}

	public void createAndShowGui() {
		// Den yttersta panelen
		mainPanel = new JPanel(new BorderLayout());

		// Grafik
		dicePanel = new JPanel();
		buttonPanel = new JPanel();

		// Initiera Model för tärningar
		game = new Game(new Player("Anders"), new Player("Danne"));
		for (Dice dice : game.getDices()) {
			// Initiera View för tärning
			DiceImage img = new DiceImage(dice);
			// Lägg till en DiceImage som observatör på en Dice
			// Lägg till tärningsbild som en observatör på en tärning
			dice.addObserver(img);
			diceImages.add(img);
		}

		// Knappen "Roll dice!" och vad som ska hända när man klickar på den
		rollButton = new JButton("Roll dice!");
		rollButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Vad som ska ske när man klickar på "Roll dice!"
				game.roll();
			}
		});

		// Lägg till tärningsbilder i panel
		for (DiceImage diceImage : diceImages) {
			dicePanel.add(diceImage);
		}

		// Lägg till knappen i en panel
		buttonPanel.add(rollButton);

		// Lägg till paneler i yttre panel
		
		gamePanel = new JPanel(new BorderLayout());
		gamePanel.add(dicePanel, BorderLayout.CENTER);
		gamePanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(gamePanel, BorderLayout.CENTER);

		ScorePanel scorePanel = new ScorePanel(game);
		
		mainPanel.add(scorePanel, BorderLayout.PAGE_END);

		add(mainPanel);

		pack();

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new RollDiceView();
	}
}
