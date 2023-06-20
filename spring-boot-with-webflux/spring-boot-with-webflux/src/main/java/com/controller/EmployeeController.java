package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

	@GetMapping(value = "employee",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Employee> getEmployee() {
		return Mono.just(new Employee(100, "Ravi", 12000));
	}
	
	@GetMapping(value = "employees",produces = MediaType.APPLICATION_GRAPHQL_VALUE)
	public Flux<Employee> getAllEmployees() {
	return Flux.fromIterable(Arrays.asList(new Employee(1, "Ravi",12000),new Employee(1, "Ravi",12000),new Employee(1, "Ravi",12000)));
	}
	
	@GetMapping(value = "response")
	public ResponseEntity<String> sayResponseMsg(){
		return ResponseEntity.ok("Hello, Welcome to Spring boot with response entity");
	}
	
	@GetMapping(value = "findEmployee/{id}")
	public Mono<ResponseEntity<Employee>> findEmployee(@PathVariable("id") int id){
		// EmployeeService return employee object or null base id 
		Employee emp = new Employee(100, "Ravi", 12000);
			if(emp.getId()==id) {
				return Mono.just(ResponseEntity.ok(emp)); 
			}else {
				return Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
			}
		
			
	}
}








