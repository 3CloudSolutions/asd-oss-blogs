package com._3cloudsolutions.demo.appconfigkeyvault;

import com._3cloudsolutions.demo.appconfigkeyvault.config.AdditionalValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.config.MoreValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.config.ValuesConfig;
import com.azure.data.appconfiguration.ConfigurationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ValuesConfig.class, MoreValuesConfig.class, AdditionalValuesConfig.class})
public class AppConfigKeyvaultApp {

    @Autowired
    private ConfigurationClient configurationClient;

    public static void main(String[] args) {
        SpringApplication.run(AppConfigKeyvaultApp.class);
    }

}
