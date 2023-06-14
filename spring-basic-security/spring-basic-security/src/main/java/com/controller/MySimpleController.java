package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class MySimpleController {

	@GetMapping(value = "say")
	public String sayHello() {
		return "Welcome to Spring default security concept";
	}
}
