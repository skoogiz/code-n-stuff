/**
 * 
 */
package com.skoogiz.monsters;

/**
 * @author ask
 *
 */
public class MonsterTemplate
{
    private MonsterTemplate(Builder builder)
    {

    }

    public Monster generate()
    {
        return new Monster();
    }

    public static class Builder
    {
        public MonsterTemplate build()
        {
            return new MonsterTemplate(this);
        }
    }

}
