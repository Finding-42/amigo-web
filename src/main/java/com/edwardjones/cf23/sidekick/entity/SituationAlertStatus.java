package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;

public enum SituationAlertStatus implements EnumClass<String>
{
    
    ACTIVE("ACTIVE"),
    CLOSED("CLOSED"),
    ADJOURNED("ADJOURNED"),
    CANCELLED("CANCELLED");
    
    private final String id;
    
    SituationAlertStatus(String id)
    {
        this.id = id;
    }
    
    public String getId()
    {
        return id;
    }
    
    @Nullable
    public static SituationAlertStatus fromId(String id)
    {
        for (SituationAlertStatus at : SituationAlertStatus.values())
        {
            if (at.getId().equals(id))
            {
                return at;
            }
        }
        return null;
    }
}