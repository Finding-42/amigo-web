package com.edwardjones.cf23.sidekick.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import software.amazon.awssdk.regions.Region;

@ConfigurationProperties(prefix = "aws")
@Data
public class AwsConfigurationProperties
{
    private Region region;
    private String accessKeyId;
    private String secretAccessKey;
    
    //    private int multipartMinPartSize = 5*1024*1024;
}
