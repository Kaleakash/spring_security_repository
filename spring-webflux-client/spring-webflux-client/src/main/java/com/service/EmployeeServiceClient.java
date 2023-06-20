package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bean.Employee;

@Service
public class EmployeeServiceClient {

	WebClient webClient;
	
	public EmployeeServiceClient(WebClient.Builder build) {  // constructor base DI
		this.webClient = build.baseUrl("http://localhost:9090/employee/").build();
	}
	
	public void findAllEmployee() {
		//webClient.get().uri("findAll").retrieve().bodyToFlux(Employee.class);	// we hit rest api // http://localhost:8080/employee/findAll
		webClient.get().uri("findAll").retrieve().bodyToFlux(Employee.class).subscribe(e->System.out.println(e));
		//webClient.get().uri("findAll").retrieve().bodyToFlux(Employee.cla
	}
}
