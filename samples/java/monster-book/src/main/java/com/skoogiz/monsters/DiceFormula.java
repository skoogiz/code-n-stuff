package com.skoogiz.monsters;

import static com.skoogiz.monsters.DiceFormulaPattern.DICE_REGEXP;
import static com.skoogiz.monsters.DiceFormulaPattern.OPERATION_PATTERN;

import java.util.regex.Matcher;

public class DiceFormula
{
    private final String formula;

    private final Dice[] dices;

    private Character op;

    private Integer modifier;

    private DiceFormula(String formula, Dice[] dices, char op, Integer modifier)
    {
        this.formula = formula;
        this.dices = dices;
        this.op = op;
        this.modifier = modifier;
    }

    public String getFormula()
    {
        return formula;
    }

    public static DiceFormula parse(String formula)
    {
        return Parser.parse(formula);
    }

    public int generate()
    {
        int sum = 0;

        for (Dice dice : dices)
        {
            sum += dice.roll();
        }

        return modify(sum);
    }

    private int modify(int sum)
    {
        switch (op)
        {
            case '+':
                sum = sum + modifier;
                break;
            case '-':
                sum = sum - modifier;
                break;
            case '*':
                sum = sum * modifier;
                break;
            case '/':
                sum = sum / modifier;
                break;

        }
        return sum;
    }

    private static class Parser
    {
        public static DiceFormula parse(final String formula)
        {
            if (DiceFormulaPattern.validFormula(formula))
            {
                char modifierOperation = ' ';
                int modifierValue = 0;
                Dice[] dices = null;

                Matcher matcher = OPERATION_PATTERN.matcher(formula);
                int operationIndex = formula.length();
                if (matcher.find())
                {
                    operationIndex = matcher.start();
                    modifierOperation = formula.charAt(operationIndex);
                    modifierValue = Integer.parseInt(formula.substring(operationIndex + 1));
                }

                String[] values = formula.substring(0, operationIndex).split(DICE_REGEXP);
                dices = new Dice[Integer.parseInt(values[0])];
                int size = Integer.parseInt(values[1]);
                for (int i = 0; i < dices.length; i++)
                {
                    dices[i] = new Dice(size);
                }

                return new DiceFormula(formula, dices, modifierOperation, modifierValue);
            }
            else
            {
                throw new IllegalArgumentException("Illegal formula '" + formula + "'!");
            }
        }
    }

}
