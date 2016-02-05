package view;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Dice;

public class DiceImage extends JLabel implements Observer {

	/**
	 * Auto generated serialVersionUID.
	 */
	private static final long serialVersionUID = -7094883111901240609L;

	private static final int SIDES_OF_DICES = 6;

	private static final ImageIcon ALERT = new ImageIcon("img/alert.png");

	private static ImageIcon[] icons = new ImageIcon[SIDES_OF_DICES];

	static {
		for (int i = 0; i < SIDES_OF_DICES; i++) {
			icons[i] = new ImageIcon("img/dice" + (i + 1) + ".png");
		}
	}

	public DiceImage() {
		setIcon(icons[0]); // Sätt bild till tärning 1 som standard
	}

	public DiceImage(Dice dice) {
		changeImage(dice);
	}

	public void changeImage(Dice dice) {
		if (SIDES_OF_DICES == dice.getSides()) {
			setIcon(icons[dice.getValue() - 1]);
		} else {
			setIcon(ALERT);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Dice) {
			changeImage((Dice) o);
		}
	}
}
