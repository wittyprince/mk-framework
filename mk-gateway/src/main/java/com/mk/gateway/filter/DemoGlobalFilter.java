package com.mk.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class DemoGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("AFilter前置逻辑");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("AFilter后置逻辑");
        }));
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 100;
    }
}
