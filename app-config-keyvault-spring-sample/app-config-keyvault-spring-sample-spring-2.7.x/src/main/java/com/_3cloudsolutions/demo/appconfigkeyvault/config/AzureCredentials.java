package com._3cloudsolutions.demo.appconfigkeyvault.config;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.spring.cloud.config.AppConfigurationCredentialProvider;
import com.azure.spring.cloud.config.KeyVaultCredentialProvider;

public class AzureCredentials implements AppConfigurationCredentialProvider, KeyVaultCredentialProvider {

    @Override
    public TokenCredential getKeyVaultCredential(String uri) {
			return getCredential();
    }

    @Override
    public TokenCredential getAppConfigCredential(String uri) {
			return getCredential();
    }

    public TokenCredential getCredential()  {
    	return new DefaultAzureCredentialBuilder().build();
    }
}