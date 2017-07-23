package com.skoogiz.monsters.template;

import com.skoogiz.monsters.dice.DiceFormula;

/**
 * 
 * @author skoogiz
 *
 */
public interface AbilityTemplate
{
    public String getName();

    public DiceFormula getDiceFormula();

    public static AbilityTemplate create(final String name, final String formula)
    {
        return new AbilityTemplate()
        {
            @Override
            public String getName()
            {
                return name;
            }

            @Override
            public DiceFormula getDiceFormula()
            {
                return DiceFormula.parse(formula);
            }
        };
    }
}
