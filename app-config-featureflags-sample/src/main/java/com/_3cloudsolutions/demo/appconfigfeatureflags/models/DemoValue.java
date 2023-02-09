package com._3cloudsolutions.demo.appconfigfeatureflags.models;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("content")
@Getter
@Setter
public class DemoValue {
    private String value1;
    private String value2;
}
