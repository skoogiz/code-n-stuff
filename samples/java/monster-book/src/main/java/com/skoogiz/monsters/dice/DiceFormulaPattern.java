package com.skoogiz.monsters.dice;

import java.util.regex.Pattern;

public final class DiceFormulaPattern
{
    public static final String DICE_FORMULA_REGEXP = "^\\d+(d|D|t|T){1}\\d+?([\\+\\-\\*\\/]{1}\\d+)?$";

    public static final String OPERATION_REGEXP = "[\\+\\-\\*\\/]{1}";

    public static final String DICE_REGEXP = "(d|D|t|T){1}";

    public static final Pattern OPERATION_PATTERN = Pattern.compile(OPERATION_REGEXP);

    public static boolean validFormula(String formula)
    {
        return formula.matches(DICE_FORMULA_REGEXP);
    }
}
