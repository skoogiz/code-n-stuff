package base;

import java.util.List;

import javax.swing.ImageIcon;

import model.Combination;
import model.Dice;
import model.Player;

public class Game {
	
	public static void print(List<Dice> dices) {
		String s = "";
		for (int i = 0; i < dices.size(); i++) {
			Dice dice = dices.get(i);
			if ( i != 0) {
				s += " : ";
			}
			s += dice.getValue();				
		}
		System.out.println(s);
	}
	
	
	public static void main (String [] args){
		
		ImageIcon icon = new ImageIcon("img/dice1.png");
		
		Player danne = new Player("Danne");
		Player anders = new Player("Anders");
		
		Yahtzee game = new Yahtzee(danne, anders);
		
		for (Combination combination  : Combination.values()) {
			for (Player player : game.getPlyers()) {
				System.out.printf("[%s] %s%n", combination, player.getName());
				game.roll();
				print(game.getDices());
				game.claculatePoints(player, combination);
				int p = game.getResult().get(player).getScore(combination);
				System.out.println("Points: " + p);
			}
		}
		
		
//		game.roll();		
//		print(game.getDices());
//		game.roll(1,3);
//		print(game.getDices());
//		
//		ScoreCard card = new ScoreCard();
//		
//		card.addScore(Label.ONE_PAIR, 12);
//		card.addScore(Label.LARGE_STRAIGHT, 20);
//		card.addScore(Label.FIVE, 15);
//		
//		System.out.println(card.sum());
//		
//		Dice dice1 = new Dice();
//		Dice dice2 = new Dice();
//		Dice dice3 = new Dice();
//		Dice dice4 = new Dice();
//		Dice dice5 = new Dice();
//		
//		Map<String, Dice> handOfDices = new LinkedHashMap<String, Dice>();
//		handOfDices.put("1#", dice1);
//		handOfDices.put("2#", dice2);
//		handOfDices.put("3#", dice3);
//		handOfDices.put("4#", dice4);
//		handOfDices.put("5#", dice5);
//		
//		for(String key : handOfDices.keySet()){
//			Dice dice = handOfDices.get(key);
//			dice.roll();
//			System.out.println(key + " " + dice.getName() + " = " + dice. getValue());
//		}
		}

}
