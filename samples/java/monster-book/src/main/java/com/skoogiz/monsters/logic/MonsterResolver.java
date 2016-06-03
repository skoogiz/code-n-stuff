package com.skoogiz.monsters.logic;

import com.skoogiz.monsters.model.Monster;
import com.skoogiz.monsters.model.Monster.Builder;
import com.skoogiz.monsters.model.MonsterTemplate;

public class MonsterResolver implements TemplateResolver<Monster>
{

    @Override
    public Monster resolve(final MonsterTemplate template)
    {
        final Builder builder = new Builder();

        template.getAbilityTemplates().forEach(
            (ability) -> builder.ability(ability.getName(), ability.getDiceFormula().generate()));

        return builder.build();
    }
}
