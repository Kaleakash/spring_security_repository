package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SampleController {

	
	@GetMapping(value = "mono")
	public Mono<String> sayHelloFromMono() {
		Mono<String> mono = Mono.just("Welcome spring boot with reactive with mono");
		return mono;
	}
	
	@GetMapping(value = "flux")
	public Flux<String> sayHelloFromFlux() {
		Flux<String> flux = Flux.just("Welcome spring boot with reactive with flux");
		return flux;
	}
}
