package com.skoogiz.monsters.logic;

import com.skoogiz.monsters.template.MonsterTemplate;

public interface TemplateResolver<T>
{
    T resolve(MonsterTemplate template);
}
