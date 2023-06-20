package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")
public class SpringBootWithResapIwithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithResapIwithJpaApplication.class, args);
		System.out.println("spring boot up");
	}

}
