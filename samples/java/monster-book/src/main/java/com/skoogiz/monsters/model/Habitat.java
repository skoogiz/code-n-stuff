package com.skoogiz.monsters.model;

/**
 * 
 * @author skoogiz
 *
 */
public interface Habitat
{
    public String getCode();

    public static Habitat create(final String code)
    {
        return () -> code;
    }
}
