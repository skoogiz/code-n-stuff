package com.skoogiz.monsters.logic;

import com.skoogiz.monsters.model.Monster;
import com.skoogiz.monsters.model.builder.MonsterBuilder;
import com.skoogiz.monsters.template.MonsterTemplate;

/**
 * 
 * @author skoogiz
 *
 */
public class MonsterResolver implements TemplateResolver<Monster>
{
    @Override
    public Monster resolve(final MonsterTemplate template)
    {
        final MonsterBuilder builder = new MonsterBuilder();

        builder.race(template.getRace());

        template.getAbilityTemplates().forEach(
            ability -> builder.ability(ability.getName(), ability.getDiceFormula().generate()));

        return builder.build();
    }
}
