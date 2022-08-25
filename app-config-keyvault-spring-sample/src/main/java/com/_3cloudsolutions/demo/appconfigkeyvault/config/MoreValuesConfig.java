package com._3cloudsolutions.demo.appconfigkeyvault.config;

import net.minidev.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "two")
public class MoreValuesConfig {
    private String textValue;
    private int integerValue;
    private String secret;

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String toJson() {
        JSONObject json = new JSONObject();
        json.put("textValue", this.textValue);
        json.put("integerValue", this.integerValue);
        json.put("secret", this.secret);
        return json.toJSONString();
    }

    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        json.put("textValue", this.textValue);
        json.put("integerValue", this.integerValue);
        json.put("secret", this.secret);
        return json;
    }
}
