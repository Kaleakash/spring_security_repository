package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.KafkaService;

@RestController
@RequestMapping("kafka")
public class KafkaController {

	@Autowired
	KafkaService kafkaService;
	
	@GetMapping(value = "send/{msg}")
	public String sendData(@PathVariable("msg") String message) {
		return kafkaService.sendData(message);
	}
}
