/**
 * 
 */
package com.skoogiz.bestiary.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ask
 *
 */
public class Character implements Serializable{

	/**
	 * Generated serialVersionUID value.
	 */
	private static final long serialVersionUID = -7790382004401760758L;

	private String name;

	private String race;

	private String movement;

	private String protection;

	private Rarity rarity;

	private final Map<String, Integer> abilities = new LinkedHashMap<>();

	private final Map<String, Integer> skills = new LinkedHashMap<>();

	private final Map<String, String> specialAbilities = new LinkedHashMap<>();

	public Character(String name) {
		this.name = name;
	}

	public static Character generateCharacter(String name, CharacterTemplate template) {
		Character character = new Character(name);
		character.setRace(template.getRace());
		character.setMovement(template.getMovement());
		character.setProtection(template.getProtection());
		character.setRarity(template.getRarity());

		for (Map.Entry<String, AbilityFormula> ability : template.getAbilities().entrySet()) {
			character.abilities.put(ability.getKey(), ability.getValue().generateValue());
		}

		character.getSkills().putAll(template.getSkills());
		character.getSpecialAbilities().putAll(template.getSpecialAbilities());

		return character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	public String getProtection() {
		return protection;
	}

	public void setProtection(String protection) {
		this.protection = protection;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Map<String, Integer> getAbilities() {
		return abilities;
	}

	public Map<String, Integer> getSkills() {
		return skills;
	}

	public Map<String, String> getSpecialAbilities() {
		return specialAbilities;
	}

	public String toJson() {
		return toJson(false);
	}
	
	public String toJson(boolean printPretty) {
		Gson gson = printPretty ? new GsonBuilder().setPrettyPrinting().create() :  new Gson();
		return gson.toJson(this);
	}
}
