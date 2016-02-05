package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import model.Game;
import model.Player;

public class PlayerLabel extends JLabel implements Observer {

	private static final long serialVersionUID = 1L;

	@Override
	public void update(Observable o, Object arg) {

		setText("Player");
		if (o instanceof Game) {
			setPlayerText(((Game) o).getCurrentPlayer());
		}

	}

	public String getPlayerString(Player player) {
		return player.getName() + " (" + player.getMarkerAsChar() + ")";
	}

	public void setPlayerText(Player player) {
		setText(getPlayerString(player));
	}
}
