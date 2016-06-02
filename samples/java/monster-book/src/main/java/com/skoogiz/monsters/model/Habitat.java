package com.skoogiz.monsters.model;

public interface Habitat
{
    public abstract String getCode();

    public static Habitat create(final String code)
    {
        return new Habitat()
        {
            @Override
            public String getCode()
            {
                return code;
            }
        };
    }
}
