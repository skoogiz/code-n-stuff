package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Game;
import controller.Manager;

/**
 * Created by Henrik on 2016-01-14.
 */
public class Board extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private int SIZE = 3;

	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel bottomPanel;

	private Manager manager = Manager.getInstance();

	private Game game;

	public Board() {
		startNewGame();
	}

	public void startNewGame() {
//		game = manager.newGame("Conan", "Swampthing");
		String player1 = JOptionPane
		.showInputDialog(
				null,
				"Pleas enter yor name",
				"Player 1",
				JOptionPane.INFORMATION_MESSAGE);
		String player2 = JOptionPane
				.showInputDialog(
						null,
						"Pleas enter yor name",
						"Player 2",
						JOptionPane.INFORMATION_MESSAGE);
		
		if (player1 == null || player2 == null) {
			System.exit(0);
		} else {
			game = manager.newGame(player1, player2);
			
			
			if (mainPanel != null) {
				mainPanel.removeAll();
				mainPanel = null;
			}
			createAndShowGui();
		}
		
		
	}

	public void createAndShowGui() {

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		topPanel = new JPanel();
		PlayerLabel playerLabel = new PlayerLabel();
		playerLabel.setPlayerText(game.getCurrentPlayer());
		game.addObserver(playerLabel);
		topPanel.add(playerLabel);
		mainPanel.add(topPanel, BorderLayout.PAGE_START);

		bottomPanel = new JPanel(new GridLayout(3, 3));
		addButtons();
		mainPanel.add(bottomPanel, BorderLayout.CENTER);

		add(mainPanel);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 640);
	}

	public void addButtons() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				final MarkerButton button = new MarkerButton(i, j);
				bottomPanel.add(button);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							manager.makeMove(game.getCurrentPlayer(),
									game.getGrid(), button.getAxisX(),
									button.getAxisY());
							button.setText(game.getCurrentPlayer().getMarker()
									.name());
							if (manager.isCurrentPlayerWinner(game)) {
								int i = JOptionPane
										.showConfirmDialog(
												null,
												game.getCurrentPlayer()
														.getName()
														+ " wins the game! Play again?",
												"Congratulation",
												JOptionPane.INFORMATION_MESSAGE);
								disableButtons();
								if (i == 0) {
									startNewGame();
								}
							} else if (!hasEmptyButtons()) {
								int i = JOptionPane
										.showConfirmDialog(
												null,
												"Showdown went into a DRAW! Play again?",
												"Info",
												JOptionPane.INFORMATION_MESSAGE);
								disableButtons();
								if (i == 0) {
									startNewGame();
								}
							} else {
								game.togglePlayer();
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,
									ex.getMessage(), "Error",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}
				});
			}
		}
	}

	public boolean hasEmptyButtons() {
		boolean hasEmpty = false;
		for (Component component : bottomPanel.getComponents()) {

			if (component instanceof JButton) {
				String txt = ((JButton) component).getText();
				hasEmpty = txt == null || "".equals(txt);
				if (hasEmpty) {
					break;
				}
			}
		}
		return hasEmpty;
	}

	public void disableButtons() {
		for (Component component : bottomPanel.getComponents()) {
			if (component instanceof JButton) {
				component.setEnabled(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}