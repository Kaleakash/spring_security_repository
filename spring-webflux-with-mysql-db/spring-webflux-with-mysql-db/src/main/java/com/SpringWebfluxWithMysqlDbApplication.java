package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.service.EmployeeService;

@SpringBootApplication(scanBasePackages = "com")
@EnableWebFlux
public class SpringWebfluxWithMysqlDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxWithMysqlDbApplication.class, args);
		System.out.println("Spring boot with webflux up!");
	
	}

}
