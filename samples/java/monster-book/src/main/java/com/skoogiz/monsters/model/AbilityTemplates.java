package com.skoogiz.monsters.model;

import java.util.Iterator;
import java.util.Vector;

public class AbilityTemplates implements Iterable<AbilityTemplate>
{
    private Vector<AbilityTemplate> abilities;

    public AbilityTemplates()
    {
        this.abilities = new Vector<AbilityTemplate>();
    }

    public void add(String name, String formula)
    {
        abilities.add(AbilityTemplate.create(name, formula));
    }

    @Override
    public Iterator<AbilityTemplate> iterator()
    {
        return abilities.iterator();
    }
}
