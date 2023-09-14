package com._3cloudsolutions.demo.appconfigkeyvault.models;

import com._3cloudsolutions.demo.appconfigkeyvault.config.AdditionalValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.config.MoreValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.config.ValuesConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Response {

    private ValuesConfig valuesConfig;
    private MoreValuesConfig moreValuesConfig;
    private AdditionalValuesConfig additionalValuesConfig;

    public Response(ValuesConfig valuesConfig,
                    MoreValuesConfig moreValuesConfig,
                    AdditionalValuesConfig additionalValuesConfig) {
        this.valuesConfig = valuesConfig;
        this.moreValuesConfig = moreValuesConfig;
        this.additionalValuesConfig = additionalValuesConfig;
    }

    public String toJson() throws JsonProcessingException {
        JSONObject obj = new JSONObject();
        obj.put("Values", valuesConfig.toJsonObject());
        obj.put("MoreValues", moreValuesConfig.toJsonObject());
        obj.put("AdditionalValues", additionalValuesConfig.toJsonObject());
        return obj.toJSONString();
    }
}
