package com.skoogiz.monsters.model;

public interface Movement
{
    public abstract String getCode();

    public static Movement create(final String code)
    {
        return new Movement()
        {
            @Override
            public String getCode()
            {
                return code;
            }
        };
    }
}
