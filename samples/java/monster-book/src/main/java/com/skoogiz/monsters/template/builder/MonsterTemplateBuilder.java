/**
 * 
 */
package com.skoogiz.monsters.template.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.skoogiz.monsters.builder.Builder;
import com.skoogiz.monsters.model.Habitat;
import com.skoogiz.monsters.model.Movement;
import com.skoogiz.monsters.model.Race;
import com.skoogiz.monsters.template.AbilityTemplate;
import com.skoogiz.monsters.template.MonsterTemplate;

/**
 * @author skoogiz
 *
 */
public final class MonsterTemplateBuilder implements Builder<MonsterTemplate>
{
    private final List<AbilityTemplate> abilities;
    private final List<Habitat> habitats;

    private Race race;
    private String rarity = "Common";
    private Movement movement;
    private Integer protection = 0;
    private String numbers = "1";

    public MonsterTemplateBuilder()
    {
        this.abilities = new ArrayList<>();
        this.habitats = new ArrayList<>();
    }

    public MonsterTemplateBuilder ability(String name, String formula)
    {
        this.abilities.add(AbilityTemplate.create(name, formula));
        return this;
    }

    public MonsterTemplateBuilder habitat(String habitat)
    {
        this.habitats.add(Habitat.create(habitat));
        return this;
    }

    public MonsterTemplateBuilder race(Race race)
    {
        this.race = race;
        return this;
    }

    public MonsterTemplateBuilder rarity(String rarity)
    {
        this.rarity = rarity;
        return this;
    }

    public MonsterTemplateBuilder movement(String movement)
    {
        this.movement = Movement.create(movement);
        return this;
    }

    public MonsterTemplateBuilder protection(Integer protection)
    {
        this.protection = protection;
        return this;
    }

    public MonsterTemplateBuilder numbers(String numbers)
    {
        this.numbers = numbers;
        return this;
    }

    @Override
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
            public Race getRace()
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
