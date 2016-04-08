/**
 * 
 */
package com.skoogiz.bestiary.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ask
 *
 */
public class CharacterTemplate {

	private final String race;

	private final String habitat;

	private final String movement;

	private final String protection;

	private final Rarity rarity;

	private final Map<String, AbilityFormula> abilities;

	private final Map<String, Integer> skills;

	private final Map<String, String> specialAbilities;

	private CharacterTemplate(Builder builder) {
		super();
		this.race = builder.race;
		this.habitat = builder.habitat;
		this.movement = builder.movement;
		this.protection = builder.protection;
		this.rarity = builder.rarity;
		this.abilities = builder.abilities;
		this.skills = builder.skills;
		this.specialAbilities = builder.specialAbilities;
	}

	public String getRace() {
		return race;
	}

	public String getHabitat() {
		return habitat;
	}

	public String getMovement() {
		return movement;
	}

	public String getProtection() {
		return protection;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public Map<String, AbilityFormula> getAbilities() {
		return abilities;
	}

	public Map<String, Integer> getSkills() {
		return skills;
	}

	public Map<String, String> getSpecialAbilities() {
		return specialAbilities;
	}

	public static class Builder {

		private final String race;

		private String habitat = "Everywhere";

		private String movement;

		private String protection = "None";

		private Rarity rarity = Rarity.COMMON;

		private Map<String, AbilityFormula> abilities = new LinkedHashMap<String, AbilityFormula>();

		private Map<String, Integer> skills = new LinkedHashMap<String, Integer>();

		private Map<String, String> specialAbilities = new LinkedHashMap<String, String>();

		public Builder(String race) {
			this.race = race;
		}

		public Builder habitat(String value) {
			this.habitat = value;
			return this;
		}

		public Builder movement(String value) {
			this.movement = value;
			return this;
		}

		public Builder protection(String value) {
			this.protection = value;
			return this;
		}

		public Builder rarity(Rarity value) {
			this.rarity = value;
			return this;
		}

		public Builder ability(String name, String formula)
				throws IllegalArgumentException {
			AbilityFormula af = new AbilityFormula(formula);
			abilities.put(name, af);
			return this;
		}

		public Builder skill(String name, Integer value) {
			skills.put(name, value);
			return this;
		}

		public Builder specialAbility(String name, String description) {
			specialAbilities.put(name, description);
			return this;
		}

		public CharacterTemplate build() {
			return new CharacterTemplate(this);
		}
	}
}
