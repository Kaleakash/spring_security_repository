package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	// http://localhost:8080/employee/findAll
	
	@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Employee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}
	
	// http://localhost:8080/employee/findById/1 
	
	@GetMapping(value = "findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Employee> findEmployeeById(@PathVariable("id") Long id) {
		return employeeService.findEmployeeById(id);
	}
	
	@PostMapping(value = "storeEmployee",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Employee> storeEmployee(@RequestBody Employee emp){
		return employeeService.save(emp);
	}
	
	@DeleteMapping(value = "deleteEmployee/{id}")
	public Mono<String> deleteEmployee(@PathVariable("id") Long id){
		return employeeService.deleteEmployee(id);
	}
	
	
}
