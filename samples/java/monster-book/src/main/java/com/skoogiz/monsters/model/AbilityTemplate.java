package com.skoogiz.monsters.model;

import com.skoogiz.monsters.DiceFormula;

public interface AbilityTemplate
{
    public abstract String getName();

    public abstract DiceFormula getDiceFormula();

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
