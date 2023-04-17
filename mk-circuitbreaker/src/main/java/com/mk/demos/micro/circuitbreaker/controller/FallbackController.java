package com.mk.demos.micro.circuitbreaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FallbackController {

    @GetMapping("/fallbackA")
    public ResponseEntity fallbackA() {
        return ResponseEntity.ok("服务不可用，降级");
    }
}
