package com._3cloudsolutions.demo.appconfigkeyvault.config;

import com.azure.spring.cloud.feature.manager.FeatureManager;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for fetching Feature Flag settings from an Azure App Configuration instance
 * The connection to App Configuration will need to be managed by the application itself
 */
@Configuration
public class AppFeatureFlagsConfig {

    private FeatureManager featureManager;
    private HashMap<String, Boolean> allFeatureFlags;
    private Set<String> allFeatureFlagNames;

    public AppFeatureFlagsConfig(FeatureManager featureManager) {
        this.featureManager = featureManager;
        setMap();
    }

    /**
     * Fetch all App Configuration Feature Flags for an endpoint
     * @return Collection of all available features with their enabled status
     */
    public HashMap<String, Boolean> getAllFeatureFlags() {
        return this.allFeatureFlags;
    }

    public Set<String> getAllFeatureFlagNames() {
        return this.allFeatureFlagNames;
    }

    public boolean isEnabled(String featureFlag) {
        if (!allFeatureFlags.containsKey(featureFlag)) {
            return false;
        }
        return this.allFeatureFlags.get(featureFlag);
    }

    public void updateFeatureFlag(String featureFlag, boolean enabledFlag) {
        this.allFeatureFlags.put(featureFlag, enabledFlag);
    }

    private void setMap(){
        this.allFeatureFlagNames = new HashSet<>();
        this.allFeatureFlags = new HashMap<>();
        Set<String> rawFeatureFlagNames = featureManager.getAllFeatureNames();
        rawFeatureFlagNames.stream().forEach(flagName -> this.allFeatureFlagNames.add(parseFeatureName(flagName)));
        rawFeatureFlagNames.forEach(flag -> this.allFeatureFlags.put(parseFeatureName(flag), featureManager.isEnabledAsync(flag).block()));
    }

    private String parseFeatureName(String name) {
        int position = name.indexOf(".");
        return name.substring(position + 1);
    }

    private String getFeatureFlagManagerName(String featureFlag) {
        return "featureManagement." + featureFlag;
    }
}
