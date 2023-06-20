package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

@RestController
@RequestMapping("employee")	// http://localhost:8080/employee/getDetails
public class EmployeeController {

	// http://localhost:8080/employee/getDetails
	@GetMapping(value = "getDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeInfo() {
		Employee emp = new Employee(100, "Ravi", 12000);
		return emp;
	}
	// http://localhost:8080/employee/getAllEmployees
	@GetMapping(value = "getAllEmployees",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployeeInfo() {
		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(new Employee(1, "Ravi", 14000));
		listOfEmp.add(new Employee(2, "Ajay", 16000));
		listOfEmp.add(new Employee(3, "Vijay", 18000));
		return listOfEmp;
	}
	// http://localhost:8080/employee/singleQueryParam?name=Ajay
	@GetMapping(value="singleQueryParam")
	public String singleQueryParam(@RequestParam("name") String name) {
		return "Welcome to Spring using query param"+name;
	}
	
	// http://localhost:8080/employee/singlePathParam/Ajay/21
	@GetMapping(value="singlePathParam/{name}/{age}")
	public String singlePathParam(@PathVariable("name") String name, @PathVariable("age") int age) {
		return "Welcome to Spring using path param"+name+"age is "+age;
	}
	
	// http://localhost:8080/employee/testPost 
	@PostMapping(value = "testPost")
	public String testPostMethod() {
		System.out.println("I Came Here");
		return "Post method test";
	}
	// http://localhost:8080/employee/storeEmployee	 method must post 
	// {"id":1,"name":"Ravi","salary":120000}
	
	@PostMapping(value = "storeEmployee",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee storeEmployee(@RequestBody Employee emp) {
		System.out.println(emp); // call toString method 
		// we can call service layer 
		//return "Employee record stored";
		return emp;
	}
	
	// http://localhost:8080/employee/updateEmployee	update method 
	@PutMapping(value = "updateEmployee",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee emp) {
		System.out.println(emp); // call toString method 
		// we can call service layer 
		emp.setSalary(emp.getSalary()+5000);
		//return "Employee record stored";
		return emp;
	}
	
	//http://localhost:8080/employee/deleteEmployee/100 
	@DeleteMapping(value = "deleteEmployee/{id}")
	public String deleteEmployeeInfo(@PathVariable("id") int id) {
		return "Employee record deleted using id as "+id;
	}
}




