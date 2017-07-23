/**
 * 
 */
package com.skoogiz.monsters.template;

import java.util.Collection;

import com.skoogiz.monsters.model.Habitat;
import com.skoogiz.monsters.model.Movement;
import com.skoogiz.monsters.model.Race;

/**
 * @author skoogiz
 *
 */
public interface MonsterTemplate
{
    public Collection<AbilityTemplate> getAbilityTemplates();

    public Race getRace();

    public String getRarity();

    public Movement getMovement();

    public Integer getProtection();

    public String getNumbers();

    public Collection<Habitat> getHabitats();
}
