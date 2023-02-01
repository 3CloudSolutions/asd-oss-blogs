package com.threecloud.kitchenbff.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.time.Duration;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterHandler {

    /**
     * Makes the resources in the static directory available
     */
    @Bean
    @Order(1)
    public RouterFunction<ServerResponse> makeStaticAvailable(
    ) {
        return RouterFunctions
                .resources("/**", new ClassPathResource("/static/"));
    }

    /**
     *
     * @param html - the static content to serve
     */
    @Bean
    @Order(2)
    public RouterFunction<ServerResponse> redirectRoot(
            @Value("classpath:/static/index.html") Resource html
    ) {
        return route(
                RequestPredicates.GET("/"),
                request -> ServerResponse
                        .ok()
                        .contentType(MediaType.TEXT_HTML)
                        .bodyValue(html)
                        .cache(Duration.ofNanos(0)))
                .and(
                    route(
                        RequestPredicates.GET("/home"),
                        request -> ServerResponse
                                .ok()
                                .contentType(MediaType.TEXT_HTML)
                                .bodyValue(html)
                                .cache(Duration.ofNanos(0)))
                );
    }


}

