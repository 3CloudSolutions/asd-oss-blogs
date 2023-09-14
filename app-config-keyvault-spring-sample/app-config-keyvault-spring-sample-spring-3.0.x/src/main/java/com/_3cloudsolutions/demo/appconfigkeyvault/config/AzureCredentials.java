package com._3cloudsolutions.demo.appconfigkeyvault.config;

import com.azure.core.credential.TokenCredential;
import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class AzureCredentials {

    //DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

    /*ConfigurationClient configurationClient = new ConfigurationClientBuilder()
            .credential(credential)
            .endpoint("https://springcloudsandbox-appconfig.azconfig.io")
            .buildClient();*/
    //@Autowired
    //private ConfigurationClient configurationClient;

    public TokenCredential getKeyVaultCredential(String uri) {
			return getCredential();
    }

    public TokenCredential getAppConfigCredential(String uri) {
			return getCredential();
    }

    public TokenCredential getCredential()  {
    	return new DefaultAzureCredentialBuilder().build();
    }
}