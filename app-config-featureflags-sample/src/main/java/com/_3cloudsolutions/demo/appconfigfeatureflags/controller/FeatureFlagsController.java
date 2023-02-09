package com._3cloudsolutions.demo.appconfigfeatureflags.controller;

import com._3cloudsolutions.demo.appconfigfeatureflags.dto.DemoValueDTO;
import com._3cloudsolutions.demo.appconfigfeatureflags.models.DemoValue;
import com.azure.spring.cloud.feature.manager.FeatureGate;
import com.azure.spring.cloud.feature.manager.FeatureManager;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class FeatureFlagsController {

    private DemoValue demoValue;
    private FeatureManager featureManager;
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public FeatureFlagsController(DemoValue demoValue,
                                  FeatureManager featureManager) {
        this.demoValue = demoValue;
        this.featureManager = featureManager;
    }

    @GetMapping(value = {"/hello", "/hellon"}, produces = APPLICATION_JSON_VALUE)
    @FeatureGate(feature = "demoFlag1", fallback = "/helloff")
    public Mono<String> getHelloOff() throws JsonProcessingException {
        DemoValueDTO demoValueDTO = new DemoValueDTO(demoValue);
        demoValueDTO.setFeatureFlagStatus("the feature flag is enabled");
        return Mono.just(toJson(demoValueDTO));
    }

    @GetMapping(value = "/helloff", produces = APPLICATION_JSON_VALUE)
    public Mono<String> getHelloOn() throws JsonProcessingException {
        DemoValueDTO demoValueDTO = new DemoValueDTO(demoValue);
        demoValueDTO.setFeatureFlagStatus("the feature flag is not enabled");
        return Mono.just(toJson(demoValueDTO));
    }

    private String toJson(Object object) throws JsonProcessingException {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return objectMapper.writeValueAsString(object);
    }

}
