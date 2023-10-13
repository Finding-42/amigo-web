package com.edwardjones.cf23.sidekick.configuration;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeAsyncClient;

@Configuration
@Slf4j
@EnableConfigurationProperties(AwsConfigurationProperties.class)
public class BedrockRuntimeClientConfiguration
{
    @Bean
    public BedrockRuntimeAsyncClient bedrockRuntimeAsyncClient(AwsConfigurationProperties awsProperties)
    {
        SdkAsyncHttpClient httpClient = NettyNioAsyncHttpClient
            .builder()
            .writeTimeout(Duration.ZERO)
            .maxConcurrency(64)
            .build();
        
        AwsCredentialsProvider awsCredentialsProvider = () ->
            AwsBasicCredentials.create(awsProperties.getAccessKeyId(), awsProperties.getSecretAccessKey());
        
        BedrockRuntimeAsyncClient bedrockRuntimeAsyncClient = BedrockRuntimeAsyncClient
            .builder()
            .credentialsProvider(awsCredentialsProvider)
            .region(awsProperties.getRegion())
            .build();
        
        return bedrockRuntimeAsyncClient;
    }
}
