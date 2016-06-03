package com.skoogiz.monsters.logic;

import com.skoogiz.monsters.model.MonsterTemplate;

public interface TemplateResolver<T>
{
    T resolve(MonsterTemplate template);
}
