/**
 * 
 */
package com.skoogiz.bestiary;

/**
 * 
 * Application constants.
 * 
 * @author ask
 *
 */
public interface Constants {

	public String SIMPLE_DICE_FORMULA_PATTERN = "^\\d+(d|D|t|T){1}\\d+$";
	
	public String DICE_FORMULA_PATTERN = "^\\d+(d|D|t|T){1}\\d+?([\\+\\-\\*\\/]{1}\\d+)?$";

	public String OPERATION_PATTERN = "[\\+\\-\\*\\/]{1}";
	
	public String DICE_PATTERN = "(d|D|t|T){1}";

}
