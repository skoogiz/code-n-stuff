package com.skoogiz.monsters;

public abstract class Ability
{
    public abstract String getName();

    public abstract int getValue();

    public static Ability create(final String name, final int value)
    {
        return new Ability()
        {
            @Override
            public int getValue()
            {
                return value;
            }

            @Override
            public String getName()
            {
                return name;
            }
        };
    }
}
