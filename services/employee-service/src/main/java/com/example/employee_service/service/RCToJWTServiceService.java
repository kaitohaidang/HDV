package com.example.employee_service.service;

import com.example.employee_service.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RCToJWTServiceService {

    private final RestClient jwtRestClient;

    public RCToJWTServiceService(
            @Qualifier("jwtRestClient") RestClient jwtRestClient
    ) {
        this.jwtRestClient = jwtRestClient;
    }

    public String getJWT(Integer id, String name) {
        return jwtRestClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new JWTData(id, name, false))
                .retrieve()
                .body(String.class);
    }
}