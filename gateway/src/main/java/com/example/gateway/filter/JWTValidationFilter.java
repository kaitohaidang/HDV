//package com.example.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Component
//public class JWTValidationFilter implements GlobalFilter, Ordered {
//
//    private final WebClient jwtWebClient = WebClient.builder()
//            .baseUrl("http://jwt-service:8080") // Container name in Docker
//            .build();
//
//    // Public endpoint that don't need validating jwt
//    private static final List<String> openEndpoints = List.of(
////            "/employee/login",
////            "/employee/register"
//            "/employee"
//    );
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        String path = request.getPath().toString();
//
//        // Public endpoints
//        if (openEndpoints.stream().anyMatch(path::startsWith)) {
//            return chain.filter(exchange);
//        }
//
//        // Get token from header
//        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//        if (token == null || !token.startsWith("Bearer ")) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//
//        // Send token to Security Service to validate
//        return jwtWebClient.post()
//                .uri("/jwt/validate")
//                .header(HttpHeaders.AUTHORIZATION, token)
//                .retrieve()
//                .bodyToMono(Boolean.class)
//                .flatMap(isValid -> {
//                    if (Boolean.TRUE.equals(isValid)) {
//                        return chain.filter(exchange);
//                    } else {
//                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                        return exchange.getResponse().setComplete();
//                    }
//                })
//                .onErrorResume(error -> {
//                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                    return exchange.getResponse().setComplete();
//                });
//    }
//
//    @Override
//    public int getOrder() {
//        return -1; // ưu tiên cao
//    }
//}
