package cn.com.clumsybear.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//@Component
public class UriKeyResolver implements KeyResolver {

	@Override
	public Mono<String> resolve(ServerWebExchange exchange) {
		System.out.println(exchange.getRequest().getURI().getPath());
		return Mono.just(exchange.getRequest().getURI().getPath());
	}

}