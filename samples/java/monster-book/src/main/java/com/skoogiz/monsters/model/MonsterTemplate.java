/**
 * 
 */
package com.skoogiz.monsters.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ask
 *
 */
public interface MonsterTemplate
{
    public abstract Collection<AbilityTemplate> getAbilityTemplates();

    public abstract String getRace();

    public abstract String getRarity();

    public abstract Movement getMovement();

    public abstract Integer getProtection();

    public abstract String getNumbers();

    public abstract Collection<Habitat> getHabitats();

    public static class Builder
    {
        private final List<AbilityTemplate> abilities;
        private final List<Habitat> habitats;

        private String race;
        private String rarity = "Common";
        private Movement movement;
        private Integer protection = 0;
        private String numbers = "1";

        public Builder()
        {
            this.abilities = new ArrayList<>();
            this.habitats = new ArrayList<>();
        }

        public Builder ability(String name, String formula)
        {
            this.abilities.add(AbilityTemplate.create(name, formula));
            return this;
        }

        public Builder habitat(String habitat)
        {
            this.habitats.add(Habitat.create(habitat));
            return this;
        }

        public Builder race(String race)
        {
            this.race = race;
            return this;
        }

        public Builder rarity(String rarity)
        {
            this.rarity = rarity;
            return this;
        }

        public Builder movement(String movement)
        {
            this.movement = Movement.create(movement);
            return this;
        }

        public Builder protection(Integer protection)
        {
            this.protection = protection;
            return this;
        }

        public Builder numbers(String numbers)
        {
            this.numbers = numbers;
            return this;
        }

        public MonsterTemplate build()
        {
            return new MonsterTemplate()
            {
                @Override
                public String getRarity()
                {
                    return rarity;
                }

                @Override
                public String getRace()
                {
                    return race;
                }

                @Override
                public Integer getProtection()
                {
                    return protection;
                }

                @Override
                public String getNumbers()
                {
                    return numbers;
                }

                @Override
                public Movement getMovement()
                {
                    return movement;
                }

                @Override
                public List<Habitat> getHabitats()
                {
                    return habitats;
                }

                @Override
                public Collection<AbilityTemplate> getAbilityTemplates()
                {
                    return abilities;
                }
            };
        }
    }

}
