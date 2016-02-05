package view;

import javax.swing.JButton;

public class MarkerButton extends JButton {

	private static final long serialVersionUID = 1L;

	private int axisX;

	private int axisY;

	public MarkerButton(int x, int y) {
		this.axisX = x;
		this.axisY = y;
	}

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

}
