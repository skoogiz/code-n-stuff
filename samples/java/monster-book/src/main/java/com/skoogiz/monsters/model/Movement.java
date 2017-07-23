package com.skoogiz.monsters.model;

/**
 * 
 * @author skoogiz
 *
 */
public interface Movement
{
    public String getCode();

    public static Movement create(final String code)
    {
        return () -> code;
    }
}
