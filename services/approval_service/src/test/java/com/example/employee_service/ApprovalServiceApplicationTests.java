package com.example.approval_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EntityScan(basePackages = "com.example.approval_service.model")
@EnableJpaRepositories(basePackages = "com.example.approval_service.repository")
public class ApprovalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprovalServiceApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}