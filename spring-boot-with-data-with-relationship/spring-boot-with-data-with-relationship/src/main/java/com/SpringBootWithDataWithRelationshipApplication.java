package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")	// enable @RestController,@Service and @Repository 
@EntityScan(basePackages = "com.bean")					// enable @Entity 
@EnableJpaRepositories(basePackages = "com.repository")// enable jpa repository features. 
public class SpringBootWithDataWithRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithDataWithRelationshipApplication.class, args);
		System.out.println("Spring boot is up");
	}

}
