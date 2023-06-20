package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
// by default @SpringBootApplication can scan all current package 
// or sub package or current package. 
public class DemoTest {

	public static void main(String[] args) {
		SpringApplication.run(DemoTest.class, args);
		System.out.println("Spring boot up");
	}

}
