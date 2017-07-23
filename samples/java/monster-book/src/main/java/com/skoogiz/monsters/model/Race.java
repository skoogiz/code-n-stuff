/**
 * 
 */
package com.skoogiz.monsters.model;

/**
 * @author skoogiz
 *
 */
public interface Race
{
    public String getName();

    public static Race create(final String name)
    {
        return () -> name;
    }
}
