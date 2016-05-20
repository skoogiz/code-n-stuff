/**
 * 
 */
package com.skoogiz.monsters;

import java.util.Random;

/**
 * @author PC
 *
 */
public class Dice
{

    private final int sides;

    private Random random;

    private int currentValue;

    public Dice(int sides)
    {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll()
    {
        return (currentValue = random.nextInt(sides) + 1);
    }

    public int getSides()
    {
        return sides;
    }

    public int getCurrentValue()
    {
        return currentValue;
    }

}
