package com.skoogiz.monsters.dice;

import static com.skoogiz.monsters.dice.DiceFormulaPattern.DICE_REGEXP;
import static com.skoogiz.monsters.dice.DiceFormulaPattern.OPERATION_PATTERN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;

public abstract class DiceFormula
{
    public abstract String getFormula();

    public abstract Integer getNumberOfDices();

    public abstract Integer getSidesOnDices();

    public abstract Character getOperator();

    public abstract Integer getModifier();

    public static DiceFormula parse(String formula)
    {
        return Parser.parse(formula);
    }

    public int generate()
    {
        int sum = asDices().stream().mapToInt(Dice::roll).sum();

        return modify(sum);
    }

    private Collection<Dice> asDices()
    {
        Collection<Dice> dices = new ArrayList<>(getNumberOfDices());
        for (int i = 0; i < getNumberOfDices(); i++)
        {
            dices.add(new Dice(getSidesOnDices()));
        }
        return Collections.unmodifiableCollection(dices);
    }

    private int modify(int sum)
    {
        switch (getOperator())
        {
            case '+':
                return sum + getModifier();
            case '-':
                return sum - getModifier();
            case '*':
                return sum * getModifier();
            case '/':
                return sum / getModifier();
            default:
                return sum;
        }
    }

    public int min()
    {
        return modify(getNumberOfDices());
    }

    public int max()
    {
        return modify(getNumberOfDices() * getSidesOnDices());
    }

    private interface Parser
    {
        public static DiceFormula parse(final String formula)
        {
            if (DiceFormulaPattern.validFormula(formula))
            {
                int nr;
                int sides;

                Matcher matcher = OPERATION_PATTERN.matcher(formula);
                boolean hasModifier = matcher.find();
                int operationIndex = hasModifier ? matcher.start() : formula.length();
                char modifierOperation = hasModifier ? formula.charAt(operationIndex) : ' ';
                int modifierValue = hasModifier ? Integer.parseInt(formula.substring(operationIndex + 1)) : 0;

                String[] values = formula.substring(0, operationIndex).split(DICE_REGEXP);
                nr = Integer.parseInt(values[0]);
                sides = Integer.parseInt(values[1]);

                return new DiceFormula()
                {

                    @Override
                    public Integer getSidesOnDices()
                    {
                        return sides;
                    }

                    @Override
                    public Character getOperator()
                    {
                        return modifierOperation;
                    }

                    @Override
                    public Integer getNumberOfDices()
                    {
                        return nr;
                    }

                    @Override
                    public Integer getModifier()
                    {
                        return modifierValue;
                    }

                    @Override
                    public String getFormula()
                    {
                        return formula;
                    }
                };
            }
            else
            {
                throw new IllegalArgumentException("Illegal formula '" + formula + "'!");
            }
        }
    }

}
