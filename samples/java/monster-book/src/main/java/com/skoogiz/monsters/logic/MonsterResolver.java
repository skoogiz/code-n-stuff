package com.skoogiz.monsters.logic;

import java.util.HashMap;
import java.util.Map;

import com.skoogiz.monsters.Ability;
import com.skoogiz.monsters.Monster;
import com.skoogiz.monsters.model.MonsterTemplate;

public class MonsterResolver implements TemplateResolver<Monster>
{

    @Override
    public Monster resolve(final MonsterTemplate template)
    {
        final Map<String, Ability> generatedAbilities = new HashMap<>();

        template.getAbilities().forEach(
            (ability) -> generatedAbilities.put(ability.getName(), Ability.create(ability.getName(), ability
                .getDiceFormula()
                .generate())));

        return new Monster()
        {
            private final Map<String, Ability> abilities = generatedAbilities;

            @Override
            public Ability getAbility(String name)
            {
                return abilities.get(name);
            }
        };
    }
}
