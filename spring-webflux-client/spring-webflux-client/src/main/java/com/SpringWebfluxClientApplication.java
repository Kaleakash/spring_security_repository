package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


import com.service.EmployeeServiceClient;

@SpringBootApplication(scanBasePackages = "com")
public class SpringWebfluxClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxClientApplication.class, args);
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.scan("com");
		ac.refresh();
		
		EmployeeServiceClient es = (EmployeeServiceClient)ac.getBean("employeeServiceClient");
		es.findAllEmployee();
		
		
		EmployeeServiceClient es1 = (EmployeeServiceClient)ac.getBean("employeeServiceClient");
		es1.findAllEmployee();
		
		System.out.println("I came here1");
		System.out.println("I came here2");
		System.out.println("I came here3");
		System.out.println("I came here4");
	}

}
