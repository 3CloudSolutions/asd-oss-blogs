package com._3cloudsolutions.demo.appconfigfeatureflags.models;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("content")
@Getter
//@Setter
public class DemoValue {
    private String value1;
    private String value2;

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
