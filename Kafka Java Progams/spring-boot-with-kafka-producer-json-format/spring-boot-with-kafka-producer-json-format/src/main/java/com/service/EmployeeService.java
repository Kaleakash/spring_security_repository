package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bean.Employee;

@Service
public class EmployeeService {

	@Autowired
	KafkaTemplate<String, Employee> kafkaTemplate;
	
	public String sendData(Employee emp) {
		//kafkaTemplate.send("employees", emp);
		Employee emp1 = new Employee(101, "Lokesh", 34000);
		Employee emp2 = new Employee(102, "Mahesh", 36000);
		Employee emp3 = new Employee(103, "Rajesh", 38000);
		kafkaTemplate.send("employees", 0, "key1", emp1);
		kafkaTemplate.send("employees", 1, "key2", emp2);
		kafkaTemplate.send("employees", 2, "key3", emp3);
		return "Data Send";
	}
}
