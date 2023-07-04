package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com")
@EnableEurekaClient
@EnableFeignClients
public class PaytmMicroServiceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaytmMicroServiceFeignClientApplication.class, args);
		System.err.println("Feign Client micro service running on port number 9393");
	}

}
