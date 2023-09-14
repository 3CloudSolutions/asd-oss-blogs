package com._3cloudsolutions.demo.appconfigkeyvault.controller;

import com._3cloudsolutions.demo.appconfigkeyvault.config.AdditionalValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.config.MoreValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.config.ValuesConfig;
import com._3cloudsolutions.demo.appconfigkeyvault.models.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;

@RestController
public class AppConfigController {

    private ValuesConfig valuesConfig;
    private MoreValuesConfig moreValuesConfig;
    private AdditionalValuesConfig additionalValuesConfig;
    private Response response;

    public AppConfigController(ValuesConfig valuesConfig,
                               MoreValuesConfig moreValuesConfig,
                               AdditionalValuesConfig additionalValuesConfig,
                               Response response) {
        this.additionalValuesConfig = additionalValuesConfig;
        this.valuesConfig = valuesConfig;
        this.moreValuesConfig = moreValuesConfig;
        this.response = response;
    }

    @GetMapping(value = "/values", produces = APPLICATION_NDJSON_VALUE)
    public Mono<String> getValues() throws JsonProcessingException {
        return Mono.just(this.valuesConfig.toJson());
    }

    @GetMapping(value = "/moreValues", produces = APPLICATION_NDJSON_VALUE)
    public Mono<String> getMoreValues() throws JsonProcessingException {
        return Mono.just(this.moreValuesConfig.toJson());
    }

    @GetMapping(value = "/additionalValues", produces = APPLICATION_NDJSON_VALUE)
    public Mono<String> getAdditionalValues() throws JsonProcessingException {
        return Mono.just(this.additionalValuesConfig.toJson());
    }

    @GetMapping(value = "/allConfigs", produces = APPLICATION_NDJSON_VALUE)
    public Flux<String> getConfigsFlux() throws JsonProcessingException {
        return Flux.just(response.toJson());
    }

    @GetMapping(value = "/allConfigsTemplate", produces = APPLICATION_NDJSON_VALUE)
    public ResponseEntity<String> getConfigsTemplate() throws JsonProcessingException {
        return new ResponseEntity<>(response.toJson(), HttpStatus.OK);
    }
}
