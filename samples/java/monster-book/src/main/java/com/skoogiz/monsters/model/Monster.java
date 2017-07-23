/**
 * 
 */
package com.skoogiz.monsters.model;

/**
 * @author skoogiz
 *
 */
public interface Monster
{
    public Race getRace();

    public Ability getAbility(String name);

    public Iterable<Ability> getAbilities();

}
