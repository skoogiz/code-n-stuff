package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.Combination;
import model.Game;
import model.Player;
import model.ScoreCard;

public class ScorePanel extends JPanel implements Observer {

	private static final long serialVersionUID = -70464616178676182L;

	private final Game game;

	public ScorePanel(Game game) {
		this.game = game;
		init();
	}

	private void init() {

		setLayout(new BorderLayout());

		ArrayList<String> columnHeaders = new ArrayList<String>();
		columnHeaders.add("#");
		for (Player player : game.getPlyers()) {
			columnHeaders.add(player.getName());
		}
				
		Object[][] tableData = new Object[Combination.size()][columnHeaders.size()];

		for (int i = 0; i < tableData.length; i++) {
			tableData[i][0] = Combination.get(i);

		}

		JTable table = new JTable(tableData, columnHeaders.toArray());

		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ScoreCard) {
			ScoreCard sc = (ScoreCard) o;
		}
		System.out.println("Hej");
		// TODO Auto-generated method stub
	}

}
