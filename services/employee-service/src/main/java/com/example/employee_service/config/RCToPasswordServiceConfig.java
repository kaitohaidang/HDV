package com.example.employee_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RCToPasswordServiceConfig {

    @Bean(name = "passwordRestClient")
    public RestClient passwordRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl("http://password-service:8080/password")
                .build();
    }
}
