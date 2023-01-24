package com._3cloudsolutions.smssender.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("sms")
@Getter
@Setter
public class SmsServerConfig {
    private String endpoint;
    private String azureKeyCredential;
    private String connectionString;
    private String fromNumber;
}
