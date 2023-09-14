package com._3cloudsolutions.demo.appconfigkeyvault.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureBootConfig {

    @Bean
    public AzureCredentials azureCredentials() {
        return new AzureCredentials();
    }
}
