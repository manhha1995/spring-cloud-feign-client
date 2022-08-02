package com.feign.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableEurekaClient
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p
				.path("/book")
				.filters(f -> f.addResponseHeader(HttpHeaders.CONTENT_TYPE, "text/plain")
				.retry(10))
				.uri("http://localhost:8761"))
			.build();
	}

	@Bean
	WebClient webClient (WebClient.Builder builder) {
		return builder.build();
	}
}
