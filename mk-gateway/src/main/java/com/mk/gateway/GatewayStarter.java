package com.mk.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.function.Predicate;

/**
 * Hello world!
 */
@Slf4j
@SpringBootApplication
public class GatewayStarter {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStarter.class, args);
    }

    /**
     * 用于readBody断言，可配置到yml
     */
    @Bean
    public Predicate<Boolean> bodyPredicate(){
        return new Predicate() {
            @Override
            public boolean test(Object o) {
                log.info("o:{}", o);
                return true;
            }
        };
    }

    // 自定义 router -> path router
    @Bean
    public RouteLocator baiduRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route_baidu", r ->
                        r.path("/baidu")
                                .filters(f -> f.stripPrefix(1))
                                .uri("https://www.baidu.com"))
                .build();
    }

}
