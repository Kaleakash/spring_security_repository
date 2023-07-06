package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerMicroSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroSeviceApplication.class, args);
		System.err.println("customer micro service running on port number 9292");
	}

}
