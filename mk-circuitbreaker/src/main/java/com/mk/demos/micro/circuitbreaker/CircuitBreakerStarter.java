package com.mk.demos.micro.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * CircuitBreaker
 */

@SpringBootApplication
public class CircuitBreakerStarter {
    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerStarter.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
