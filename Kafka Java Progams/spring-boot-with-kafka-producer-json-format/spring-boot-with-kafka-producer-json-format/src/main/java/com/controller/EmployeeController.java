package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.service.EmployeeService;

@RestController
@RequestMapping("kafka")
public class EmployeeController {

	@Autowired 
	EmployeeService employeeService;
	@PostMapping(value = "employee",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sendEmployee(@RequestBody Employee emp) {
		return employeeService.sendData(emp);
	}
}
