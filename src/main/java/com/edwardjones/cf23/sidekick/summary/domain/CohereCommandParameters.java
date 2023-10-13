package com.edwardjones.cf23.sidekick.summary.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
@With
public class CohereCommandParameters
{
    private List<String> stopSequences;
    private ReturnLikelihood returnLikelihoods;
    private String prompt;
    private float p;
    private float temperature;
    private int k;
    private int maxTokens;
    
    public static CohereCommandParameters usingPrompt(String prompt)
    {
        return CohereCommandParameters.builder()
                                      .prompt(prompt)
                                      .p(0.01f)
                                      .k(0)
                                      .temperature(0.75f)
                                      .returnLikelihoods(ReturnLikelihood.NONE)
                                      .stopSequences(List.of())
                                      .maxTokens(400)
                                      .build();
    }
    
    public enum ReturnLikelihood
    {
        GENERATION, ALL, NONE;
    }
}
