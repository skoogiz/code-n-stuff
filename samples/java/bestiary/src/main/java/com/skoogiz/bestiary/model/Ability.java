/**
 * 
 */
package com.skoogiz.bestiary.model;

/**
 * 
 * Class representation of an ability.
 * 
 * @author ask
 *
 */
public class Ability implements NamedValue<String, Integer> {

	/**
	 * Generated value.
	 */
	private static final long serialVersionUID = 4285055447184973163L;

	private String name;

	private Integer value;
	
	private String formula;

	public Ability(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public Ability(String name, Integer value, String formula) {
		super();
		this.name = name;
		this.value = value;
		this.formula = formula;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getFormula() {
		return formula;
	}
}
