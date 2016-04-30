/**
 * 
 */
package com.skoogiz.bestiary.web;

import static spark.Spark.*;

import com.skoogiz.bestiary.model.Character;
import com.skoogiz.bestiary.model.CharacterTemplate;
import com.skoogiz.bestiary.model.Rarity;

/**
 * @author skoogiz
 *
 */
public class Start {

	public static void main(String[] args) {
		get("/bestiary", (req, res) -> genCharacter("Alorion"));
	}

	public static String genCharacter(String name) {
		CharacterTemplate template = new CharacterTemplate.Builder("Högalv")
				.rarity(Rarity.RARE).habitat("4ABG").movement("L10")
				.ability("STY", "2T6+3").ability("STO", "2T4+7")
				.ability("FYS", "1T6+2").ability("SMI", "3T6")
				.ability("INT", "4T6").ability("PSY", "4T6+1")
				.ability("KAR", "3T6").skill("Gömma sig", 6)
				.skill("Upptäcka fara", 10).build();
		return Character.generateCharacter(name, template).toJson(true);
	}
	
}
