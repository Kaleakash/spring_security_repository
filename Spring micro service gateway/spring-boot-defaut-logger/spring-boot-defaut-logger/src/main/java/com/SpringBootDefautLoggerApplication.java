package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDefautLoggerApplication {

	
	static Logger logger = LoggerFactory.getLogger(SpringBootDefautLoggerApplication.class);
	public static void main(String[] args) {
		logger.warn("This my cutom warning message");
		logger.info("This my cutom info message");
		logger.error("This my cutom error message");
		SpringApplication.run(SpringBootDefautLoggerApplication.class, args);
		
	}

}
