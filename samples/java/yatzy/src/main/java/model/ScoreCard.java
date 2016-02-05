package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreCard {

	private final Map<Combination, Integer> scores = new LinkedHashMap<>();
	
	public ScoreCard() {
		for (Combination Combination : Combination.values()) {
			scores.put(Combination, null);
		}
	}
	
	public void addScore(Combination combination, int score) {
		scores.put(combination, score);
	}
	
	public int sum() {
		int sum = 0;
		for (Integer score : scores.values()) {
			if (score != null) {
				sum += score;
			}
		}
		return sum;
	}
	
	public int getScore(Combination Combination) {
		return scores.get(Combination);
	}
	
	public Map<Combination, Integer> getScores() {
		return Collections.unmodifiableMap(scores);
	}
	
}
