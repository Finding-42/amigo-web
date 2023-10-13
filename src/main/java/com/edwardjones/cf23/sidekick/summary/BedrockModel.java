package com.edwardjones.cf23.sidekick.summary;

public enum BedrockModel
{
    CLAUDE_V1_INSTANT
        {
            @Override
            public String getModelId()
            {
                return "anthropic.claude-instant-v1";
            }
        },
    COHERE_COMMAND
        {
            @Override
            public String getModelId()
            {
                return "cohere.command-text-v14";
            }
        };
    
    public String getModelId()
    {
        return "anthropic.claude-instant-v1";
    }
}
