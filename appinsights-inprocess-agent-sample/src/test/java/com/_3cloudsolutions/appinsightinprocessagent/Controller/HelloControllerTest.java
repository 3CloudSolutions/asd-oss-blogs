package com._3cloudsolutions.appinsightinprocessagent.Controller;


import com._3cloudsolutions.appinsightinprocessagent.AppInsightInprocessAgentApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = AppInsightInprocessAgentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class HelloControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    void get() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/api/hello", String.class);
        assertThat(response.getBody()).isEqualTo("Hello World, Spring Boot!");
    }
}