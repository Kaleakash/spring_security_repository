package com.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "sample",groupId = "g1")
	public void receiveMessage(String message) {
		System.err.println(message);
	}
}
