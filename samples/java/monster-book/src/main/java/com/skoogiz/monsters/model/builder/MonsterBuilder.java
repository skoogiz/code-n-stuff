/**
 * 
 */
package com.skoogiz.monsters.model.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skoogiz.monsters.builder.Builder;
import com.skoogiz.monsters.model.Ability;
import com.skoogiz.monsters.model.Monster;
import com.skoogiz.monsters.model.Race;

/**
 * @author skoogiz
 *
 */
public final class MonsterBuilder implements Builder<Monster>
{
    private List<Ability> abilities = new ArrayList<>();

    private Race race;

    public MonsterBuilder ability(Ability ability)
    {
        abilities.add(ability);
        return this;
    }

    public MonsterBuilder ability(String name, int value)
    {
        return ability(Ability.create(name, value));
    }

    public MonsterBuilder race(Race race)
    {
        this.race = race;
        return this;
    }

    @Override
    public Monster build()
    {
        final Map<String, Ability> generatedAbilities = new HashMap<>();

        abilities.forEach(ability -> generatedAbilities.put(ability.getName(), ability));

        return new Monster()
        {
            private final Map<String, Ability> mappedAbilities = generatedAbilities;

            @Override
            public Race getRace()
            {
                return race;
            }

            @Override
            public Ability getAbility(String name)
            {
                return mappedAbilities.get(name);
            }

            @Override
            public Iterable<Ability> getAbilities()
            {
                return mappedAbilities.values();
            }
        };
    }
}
