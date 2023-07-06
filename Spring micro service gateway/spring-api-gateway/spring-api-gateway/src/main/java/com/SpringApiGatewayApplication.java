package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpringApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGatewayApplication.class, args);
		System.err.println("spring micro gateway running on port number 9595");
	}

	@Bean
	public RouteLocator myCustomeRouterLocator(RouteLocatorBuilder builder) {
		System.out.println("I Came here");
		//return builder.routes().route(r->r.path("/employee/**").and().method("GET").uri("http://localhost:9191")).build();
		
//		return builder.routes().route(r->r.path("/employee/**").and().method("GET").uri("http://localhost:9191")).
//				route(r->r.path("/customer/**").and().method("GET").uri("http://localhost:9292")).build();
		
		return builder.routes().route(r->r.path("/employee/**").and().method("GET","POST").
				filters(f->f.addRequestParameter("msg", "Welcome").addResponseHeader("response-key", "reponse-value")).uri("http://localhost:9191")).
				route(r->r.path("/customer/**").and().method("GET").uri("http://localhost:9292")).build();
		
	}
}
