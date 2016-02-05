package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Combination;
import model.Dice;
import model.Player;
import model.ScoreCard;

public class Yahtzee {

	private final static int DICE_TYPE = 6;

	private final Map<Player, ScoreCard> playersBoard = new LinkedHashMap<>();

	private Dice[] dices = { new Dice(DICE_TYPE), new Dice(DICE_TYPE), new Dice(DICE_TYPE), new Dice(DICE_TYPE),
			new Dice(DICE_TYPE) };

	public Yahtzee(Player... players) {
		init(Arrays.asList(players));
	}

	public Yahtzee(List<Player> players) {
		init(players);
	}

	private void init(List<Player> players) {
		for (Player player : players) {
			playersBoard.put(player, new ScoreCard());
		}
	}

	public Set<Player> getPlyers() {
		return playersBoard.keySet();
	}

	public Map<Player, ScoreCard> getResult() {
		return Collections.unmodifiableMap(playersBoard);
	}

	// public Map<Player, ScoreCard> start() {
	//
	// for (int i = 0; i < nrOfRounds; i++) {
	// doRound();
	// }
	//
	// return Collections.unmodifiableMap(playersBoard);
	//
	// }
	//
	// public void doRound() {
	// for (Player player : playersBoard.keySet()) {
	// doTurn(player);
	// }
	// }
	//
	// public void doTurn(Player player) {
	//
	// }

	/**
	 * Pass index of dice that will not be rolled.
	 * 
	 * @param index
	 */
	public void roll(Integer... indexs) {
		for (int i = 0; i < dices.length; i++) {
			if (Arrays.binarySearch(indexs, i) < 0) {
				Dice dice = dices[i];
				dice.roll();
			}
		}
	}

	public List<Dice> getDices() {
		return Arrays.asList(dices);
	}

	public void claculatePoints(Player player, Combination combination) {

		int points = 0;

		switch (combination) {
		case ONES:
			points = calculateNumbers(1);
			break;
		case TWOS:
			points = calculateNumbers(2);
			break;
		case THREES:
			points = calculateNumbers(3);
			break;
		case FOURS:
			points = calculateNumbers(4);
			break;
		case FIVES:
			points = calculateNumbers(5);
			break;
		case SIXES:
			points = calculateNumbers(6);
			break;
		case ONE_PAIR:
			points = count(2);
			break;
		case TWO_PAIRS:
			points = countTwoPairs();
			break;
		case THREE_OF_A_KIND:
			points = count(3);
			break;
		case FOUR_OF_A_KIND:
			points = count(4);
			break;
		case SMALL_STRAIGHT:
			if (isStraight(6)) {
				points = 15;
			}
			break;
		case LARGE_STRAIGHT:
			if (isStraight(1)) {
				points = 20;
			}
			break;
		case FULL_HOUSE:
			points = countFullHouse();
			break;
		case CHANCE:
			for (Dice dice : dices) {
				points += dice.getValue();
			}
			break;
		case YATZY:
			if (isYahtzee()) {
				points = 50;
			}
			break;

		}

		updatePoints(player, combination, points);

	}

	private int countFullHouse() {
		List<List<Integer>> grid = getResults();
		
		int points = 0;
		
		for (List<Integer> list : grid) {
			int size = list.size();
			if (size == 1 || size == 4 || size == 5) {
				points = 0;
				return points;
			} else {
				for (Integer integer : list) {
					points += integer;
				}
			}
		}
				
		return points;
	}

	private List<List<Integer>> getResults() {
		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		for (int i = 0; i < DICE_TYPE; i++) {
			grid.add(new ArrayList<>());
		}

		for (Dice dice : dices) {
			grid.get(dice.getValue() - 1).add(dice.getValue());
		}

		return grid;
	}

	private int count(int nrOfAKind) {
		List<List<Integer>> grid = getResults();
		
		int points = 0;
		
		for (List<Integer> list : grid) {
			if (list.size() >= nrOfAKind) {
				int tmpPoints = 0;
				for (int i = 0; i < nrOfAKind; i++) {
					tmpPoints += list.get(i);					
				}
				if (tmpPoints > points) {
					points = tmpPoints;
				}
				
			}
		}
		
		return points;
	}
	
	private int countTwoPairs() {
		List<List<Integer>> grid = getResults();
		
		int points = 0;
		
		
		for (List<Integer> list : grid) {
			if (list.size() >= 2) {
				int tmpPoints = 0;
				for (int i = 0; i < 2; i++) {
					tmpPoints += list.get(i);					
				}
				if (points > 0) {
					points += tmpPoints;
					return points;
				} else {
					points = tmpPoints;
				}
				
			}
		}
		
		return 0;
	}
	
	private boolean isYahtzee() {
		int value = dices[0].getValue();
		for (int i = 1; i < dices.length; i++) {
			if (value != dices[i].getValue()) {
				return false;
			}
		}
		return true;
	}

	private boolean isStraight(int ignore) {
		Set<Integer> straight = new HashSet<>();
		for (Dice dice : dices) {
			if (dice.getValue() != ignore) {
				straight.add(dice.getValue());
			}
		}
		return straight.size() == dices.length;
	}

	private int calculateNumbers(int value) {
		int score = 0;
		for (Dice dice : dices) {
			if (value == dice.getValue()) {
				score += dice.getValue();
			}
		}
		return score;
	}

	private void updatePoints(Player player, Combination combination, int points) {
		if (playersBoard.containsKey(player)) {
			playersBoard.get(player).addScore(combination, points);
		}
	}

}
