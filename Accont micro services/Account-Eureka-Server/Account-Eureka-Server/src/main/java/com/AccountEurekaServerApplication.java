package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AccountEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountEurekaServerApplication.class, args);
		System.out.println("Spring boot eureka server upon on port number 8761");
	}

}
