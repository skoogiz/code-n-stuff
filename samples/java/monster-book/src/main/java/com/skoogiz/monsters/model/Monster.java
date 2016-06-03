/**
 * 
 */
package com.skoogiz.monsters.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ask
 *
 */
public abstract class Monster
{
    public abstract String getRace();

    public abstract Ability getAbility(String name);

    public abstract Iterable<Ability> getAbilities();

    public static class Builder
    {
        private List<Ability> abilities = new ArrayList<>();

        private String race;

        public Builder ability(Ability ability)
        {
            abilities.add(ability);
            return this;
        }

        public Builder ability(String name, int value)
        {
            return ability(Ability.create(name, value));
        }

        public Builder race(String race)
        {
            this.race = race;
            return this;
        }

        public Monster build()
        {
            final Map<String, Ability> generatedAbilities = new HashMap<>();

            abilities.forEach(
                (ability) -> generatedAbilities.put(ability.getName(), ability));

            return new Monster()
            {

                private final Map<String, Ability> mappedAbilities = generatedAbilities;

                @Override
                public String getRace()
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

}
