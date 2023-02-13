package com._3cloudsolutions.demo.appconfigfeatureflags;

import com._3cloudsolutions.demo.appconfigfeatureflags.models.DemoValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({DemoValue.class})
public class AppConfigFeatureflagsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppConfigFeatureflagsApplication.class, args);
    }

}
