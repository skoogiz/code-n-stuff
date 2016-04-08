/**
 * 
 */
package com.skoogiz.bestiary.model;

import java.util.Map;

/**
 * @author ask
 *
 */
public class Character {

	public static void main(String[] args) {
		CharacterTemplate template = new CharacterTemplate.Builder("Högalv")
				.rarity(Rarity.RARE).habitat("4ABG").movement("L10")
				.ability("STY", "2T6+3").ability("STO", "2T4+7")
				.ability("FYS", "1T6+2").ability("SMI", "3T6")
				.ability("INT", "4T6").ability("PSY", "4T6+1")
				.ability("KAR", "3T6").skill("Gömma sig", 6)
				.skill("Upptäcka fara", 10).build();

		System.out.printf("Ras: %s%n", template.getRace());
		System.out.printf("Hemvist: %s%n", template.getHabitat());
		System.out.printf("Vanlighet: %s%n", template.getRarity().name());
		System.out.printf("Grundegenskaper%n");
		for (String name : template.getAbilities().keySet()) {
			System.out.printf("  %s > %s%n", name,
					template.getAbilities().get(name));
		}
		System.out.printf("Förmågor%n");
		for (String name : template.getSpecialAbilities().keySet()) {
			System.out.printf("  %s > %s%n", name, template
					.getSpecialAbilities().get(name));
		}
		System.out.printf("Färdigheter%n");
		for (String name : template.getSkills().keySet()) {
			System.out.printf("  %s > %s%n", name,
					template.getSkills().get(name));
		}
		System.out.printf("Förflyttning: %s%n", template.getMovement());
		System.out.printf("Naturliga Skydd: %s%n", template.getProtection());

	}
}
