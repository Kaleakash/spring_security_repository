package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.support.serializer.JsonSerializer;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootWithKafkaProducerJsonFormatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaProducerJsonFormatApplication.class, args);
		//JsonSerializer
		System.out.println("Kafka publish json data up!");
	}

}
