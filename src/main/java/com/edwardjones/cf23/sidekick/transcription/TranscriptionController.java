package com.edwardjones.cf23.sidekick.transcription;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("transcription")
public class TranscriptionController
{
    private final TranscriptionService transcriptionService;
    
    @GetMapping
    public Mono<String> transcribeAudio()
    {
        return Mono.just("");
    }
}
