package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootWithKafaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafaProducerApplication.class, args);
		System.out.println("Kafka Producer application up!");
	}

}
