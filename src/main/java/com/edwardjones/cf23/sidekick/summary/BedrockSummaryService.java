package com.edwardjones.cf23.sidekick.summary;

import com.edwardjones.cf23.sidekick.summary.domain.AnthropicClaudeParameters;
import com.edwardjones.cf23.sidekick.summary.domain.CohereCommandParameters;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.IOException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeAsyncClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class BedrockSummaryService
{
    
    private final BedrockRuntimeAsyncClient bedrockRuntimeAsyncClient;
    
    public Mono<String> summarizeText(@NonNull String text, BedrockModel model)
    {
        return Mono.fromCallable(() ->
                                 {
                                     ObjectMapper mapper = new JsonMapper();
                                     mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
                                     mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                                     
                                     return switch (model)
                                     {
                                         case COHERE_COMMAND ->
                                             mapper.writeValueAsString(CohereCommandParameters.usingPrompt(text));
                                         case CLAUDE_V1_INSTANT ->
                                             mapper.writeValueAsString(AnthropicClaudeParameters.usingPrompt(text));
                                     };
                                 })
                   .doOnNext(body -> log.info(body))
                   .map(body -> InvokeModelRequest.builder()
                                                  .modelId(model.getModelId())
                                                  .body(SdkBytes.fromUtf8String(body))
                                                  .build())
                   .flatMap(request -> Mono.fromFuture(bedrockRuntimeAsyncClient.invokeModel(request)))
                   .map(response ->
                        {
                            ObjectMapper mapper = new JsonMapper();
                            try
                            {
                                return mapper.readTree(response.body().asByteArray())
                                             .findValue("text")
                                             .asText();
                            } catch (IOException e)
                            {
                                throw new RuntimeException(e);
                            }
                        });
    }
}
