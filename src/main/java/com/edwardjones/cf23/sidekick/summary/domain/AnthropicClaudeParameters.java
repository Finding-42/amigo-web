package com.edwardjones.cf23.sidekick.summary.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import static java.lang.String.format;

@Data
@Builder
@With
public class AnthropicClaudeParameters
{
    private List<String> stopSequences;
    private String prompt;
    private float temperature;
    private float topP;
    private int maxTokensToSample;
    private int topK;
    
    public static AnthropicClaudeParameters usingPrompt(String prompt)
    {
        return AnthropicClaudeParameters.builder()
                                        .build();
    }
    
    public void setPrompt(String prompt)
    {
        this.prompt = format("\n\nHuman:%s\n\nAssistant:");
    }
}
