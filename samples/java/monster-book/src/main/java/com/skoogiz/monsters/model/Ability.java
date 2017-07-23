package com.skoogiz.monsters.model;

/**
 * 
 * @author skoogiz
 *
 */
public interface Ability
{
    public String getName();

    public int getValue();

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
