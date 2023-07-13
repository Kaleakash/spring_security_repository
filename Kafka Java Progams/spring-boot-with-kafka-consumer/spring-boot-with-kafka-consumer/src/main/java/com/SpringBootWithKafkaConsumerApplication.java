package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootWithKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaConsumerApplication.class, args);
		System.out.println("Spring boot kafka consumer up on port number 8181");
	}

}
