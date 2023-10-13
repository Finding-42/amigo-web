package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;

public enum Role implements EnumClass<String>
{
    
    SME("SME"),
    STAKEHOLDER("STAKEHOLDER"),
    FACILITATOR("FACILITATOR"),
    OBSERVER("OBSERVER");
    
    private final String id;
    
    Role(String id)
    {
        this.id = id;
    }
    
    public String getId()
    {
        return id;
    }
    
    @Nullable
    public static Role fromId(String id)
    {
        for (Role at : Role.values())
        {
            if (at.getId().equals(id))
            {
                return at;
            }
        }
        return null;
    }
}