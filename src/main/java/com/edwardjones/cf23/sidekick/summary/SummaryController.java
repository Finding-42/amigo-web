package com.edwardjones.cf23.sidekick.summary;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("summary")
public class SummaryController
{
    private final BedrockSummaryService summaryService;
    
    @PostMapping
    public Mono<String> summarizeText(@RequestBody String text)
    {
        return summaryService.summarizeText(text, BedrockModel.COHERE_COMMAND);
    }
}
