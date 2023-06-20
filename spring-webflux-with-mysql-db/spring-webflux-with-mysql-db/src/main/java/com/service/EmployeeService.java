package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Flux<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}
	
	public Mono<Employee> findEmployeeById(Long id){
		return employeeRepository.findById(id);
	}
	
	public Mono<Employee> save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Mono<String> deleteEmployee(Long id){
		employeeRepository.deleteById(id);
		return Mono.just("Record deleted");
	}
	
	public void updateEmployee(Employee emp) {
		employeeRepository.updateEmployeeRecord(emp.getSalary(), emp.getId());
	}
}
