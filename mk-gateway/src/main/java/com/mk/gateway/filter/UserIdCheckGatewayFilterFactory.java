package com.mk.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class UserIdCheckGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return new UserIdCheckGateWayFilter();
    }


    @Slf4j
    static class UserIdCheckGateWayFilter implements GatewayFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            String url = exchange.getRequest().getPath().pathWithinApplication().value();
            log.info("UserIdCheckGatewayFilter, 请求URL:[{}]", url);
            log.info("UserIdCheckGatewayFilter, 请求method:[{}]", exchange.getRequest().getMethod());
            //获取header
            String userId = exchange.getRequest().getHeaders().getFirst("userId");
            log.info("UserIdCheckGatewayFilter, userId：[{}]", userId);
            if (!StringUtils.hasText(userId)) {
                log.error("***** UserIdCheckGatewayFilter, 头部验证不通过，请在头部输入userId *****");
                //终止请求，直接回应
                exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
            return HIGHEST_PRECEDENCE + 500;
        }
    }
}
