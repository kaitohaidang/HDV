package com.example.employee_service.service;

import com.example.employee_service.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RCToPasswordServiceService {

    private final RestClient passwordRestClient;

    public RCToPasswordServiceService(
            @Qualifier("passwordRestClient") RestClient passwordRestClient
    ) {
        this.passwordRestClient = passwordRestClient;
    }

    public String createPassword(String rawPassword) {
        return passwordRestClient.post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new RawPassword(rawPassword))
                .retrieve()
                .body(String.class);
    }

    public Boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordRestClient.post()
                .uri("/check")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new RawEncodedPassword(rawPassword, encodedPassword))
                .retrieve()
                .body(Boolean.class);
    }
}