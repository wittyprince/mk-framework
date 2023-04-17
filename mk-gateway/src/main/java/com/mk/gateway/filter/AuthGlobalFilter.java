package com.mk.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 用于auth校验
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("MyAuthFilter权限过滤器 前置逻辑");
        String token = exchange.getRequest().getHeaders().getFirst("access_token");
        String path = exchange.getRequest().getURI().getPath();
        log.info("请求path:[{}]", path);

        if (!StringUtils.hasText(token)/* && (StringUtils.hasText(path) && !path.contains("/login"))*/) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("MyAuthFilter权限过滤器 后置逻辑");
        }));
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 200;
    }
}
