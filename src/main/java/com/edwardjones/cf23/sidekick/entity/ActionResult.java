package com.edwardjones.cf23.sidekick.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;

public enum ActionResult implements EnumClass<String>
{
    
    NO_CHANGE("NO_CHANGE"),
    RESOLVED("RESOLVED"),
    ROLLBACK("ROLLBACK"),
    PENDING("PENDING");
    
    private final String id;
    
    ActionResult(String id)
    {
        this.id = id;
    }
    
    public String getId()
    {
        return id;
    }
    
    @Nullable
    public static ActionResult fromId(String id)
    {
        for (ActionResult at : ActionResult.values())
        {
            if (at.getId().equals(id))
            {
                return at;
            }
        }
        return null;
    }
}