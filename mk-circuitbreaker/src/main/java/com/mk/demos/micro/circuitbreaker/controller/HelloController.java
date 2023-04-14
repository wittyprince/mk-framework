package com.mk.demos.micro.circuitbreaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
//@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public String account(@PathVariable("id") int id) throws InterruptedException {
        if (1 == id) {
            Thread.sleep(10000);
        }
        log.info("========id: {}", id);
        return "Constants.ACCOUNT_PREFIX + dateStr()=======" + id;
    }
}
