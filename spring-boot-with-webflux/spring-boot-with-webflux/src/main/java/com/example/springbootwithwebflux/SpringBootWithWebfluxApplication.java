package com.example.springbootwithwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootWithWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithWebfluxApplication.class, args);
		System.out.println("Spring boot with reactive up");
	}

}
