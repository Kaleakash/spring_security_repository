package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public String sendData(String message) {
		kafkaTemplate.send("sample", "Welcome to Kafka Message publish through spring boot");
		kafkaTemplate.send("sample", message);
		return "Data Send";
	}
}
