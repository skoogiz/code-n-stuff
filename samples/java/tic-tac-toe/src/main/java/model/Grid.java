package model;

public class Grid {


	private final Character[][] table;

	private final int win;

	// konstruktor för brädet character för att kunna nulla
	public Grid(int size, int win) {
		this.table = new Character[size][size];
		this.win = win;
	}

	public boolean makeMove(char marker, int x, int y) throws Exception {
		// Kolla att x & y inte är större än tabellen och Kolla att noden är tom
		// och kan lägga marker lr false kör igen
		if (!(x > table.length && y > table.length) && table[x][y] == null) {
			table[x][y] = marker;
			return true;
		}
		throw new Exception("Illegal move!");
	}

	public boolean validate(char marker) {

		int count = 0;

		// Kolla raderna
		for (Character[] row : table) {
			// cellen i raden
			for (Character sq : row) {
				// finns markör räkna upp
				if (sq != null && marker == sq) {
					count++;
				} else {
					count = 0;
				}
				// kollar vinst
				if (count == win) {
					return true;
				}
			}
			// nollställer för nästa rad
			count = 0;
		}

		// Kolla kolumner
		for (int i = 0; i < table.length; i++) {
			// kollar rader
			for (int d = 0; d < table.length; d++) {

				Character sq = table[d][i];
				if (sq != null && marker == sq) {
					count++;
				} else {
					count = 0;
				}
				if (count == win) {
					return true;
				}
			}
			count = 0;
		}

		// Kolla diagonalerna
		for (int i = 0; i < table.length; i++) {
			for (int d = 0; d < table.length; d++) {
				Character sq = table[i][d];

				if (sq != null && marker == sq) {
					if (win - i >= table.length && win - d >= table.length) {
						while (sq != null && marker == sq) {
							count++;
							if (count == win) {
								return true;
							}
							// kollar att nästa cell är plus en rad & plus en
							// kolumn
							sq = table[++i][++d];
						}
					}

				} else {
					count = 0;
				}
			}
			count = 0;
		}
		// Kolla diagonalerna med kolumner baklänges
		for (int i = 0; i < table.length; i++) {
			for (int d = table.length - 1; d >= 0; d--) {
				Character sq = table[i][d];
				if (sq != null && marker == sq) {
					if (win - i >= table.length && win - d >= 0) {
						while (sq != null && marker == sq) {
							count++;
							if (count == win) {
								return true;
							} else if (d == 0)
								break;
							sq = table[++i][--d];
						}
					}
				} else {
					count = 0;
				}

			}
			count = 0;
		}

		return false;
	}

	public Character[][] getTable() {
		return table;
	}

}
