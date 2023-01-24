package com._3cloudsolutions.smssender.config;

import com.azure.communication.sms.SmsAsyncClient;
import com.azure.communication.sms.SmsClient;
import com.azure.communication.sms.SmsClientBuilder;
import com.azure.communication.sms.SmsServiceVersion;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.HttpClient;
import com.azure.identity.DefaultAzureCredentialBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsClientConfig {

    private SmsServerConfig smsServerConfig;

    public SmsClientConfig(SmsServerConfig smsServerConfig){
        this.smsServerConfig = smsServerConfig;
    }

    @Bean
    public SmsClient smsClient() {
        return new SmsClientBuilder()
                // Key credential works below
                .endpoint(smsServerConfig.getEndpoint())
                .credential(new AzureKeyCredential(smsServerConfig.getAzureKeyCredential()))

                // Connection String works below
                //.connectionString(smsServerConfig.getConnectionString())

                // DefaultCredentialBuilder below won't work CURRENTLY without client_id, tenant and secret
                // Microsoft hasn't implemented it yet
                //
                //.endpoint(smsServerConfig.getEndpoint())
                //.credential(new DefaultAzureCredentialBuilder().build())

                .httpClient(HttpClient.createDefault())
                .serviceVersion(SmsServiceVersion.V2021_03_07)
                .buildClient();
    }

    @Bean
    public SmsAsyncClient smsAsyncClient() {
        return new SmsClientBuilder()
                // Key credential works below
                .endpoint(smsServerConfig.getEndpoint())
                .credential(new AzureKeyCredential(smsServerConfig.getAzureKeyCredential()))

                // Connection String works below
                //.connectionString(smsServerConfig.getConnectionString())

                // DefaultCredentialBuilder below won't work CURRENTLY without client_id, tenant and secret
                // Microsoft hasn't implemented it yet
                //
                //.endpoint(smsServerConfig.getEndpoint())
                //.credential(new DefaultAzureCredentialBuilder().build())

                .httpClient(HttpClient.createDefault())
                .serviceVersion(SmsServiceVersion.V2021_03_07)
                .buildAsyncClient();
    }
}
