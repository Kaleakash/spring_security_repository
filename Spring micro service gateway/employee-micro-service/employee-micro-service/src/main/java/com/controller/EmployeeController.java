package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	static List<Employee> listOfEmployees;
	static {
		listOfEmployees = new ArrayList<>();
		logger.info("list of employee object created...");
		listOfEmployees.add(new Employee(1, "Ravi", 12000));
		listOfEmployees.add(new Employee(2, "Ramesh", 16000));
		listOfEmployees.add(new Employee(3, "Rajesh", 18000));
		logger.info("3 employee record stored");
		logger.info("size of employee "+listOfEmployees.size());
	}
	
	@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findAllEmployee() {
		logger.info("find all employee called..");
		logger.info("Number of records going to display in json format "+listOfEmployees.size());
		List<Employee> listOfEmployees = new ArrayList<>();
		logger.info("Number of records going to display in json format "+listOfEmployees.size());
		return listOfEmployees;
	}
	@GetMapping(value = "findEmployee")
	public String findEmployee(@RequestParam("id") String id, @RequestParam("msg") String msg) {
			try {
				int empid = Integer.parseInt(id);
			Iterator<Employee> li = listOfEmployees.iterator();
			while(li.hasNext()){
				logger.info("While loop execute");
				Employee emp = li.next();
				if(emp.getId()==empid) {
					return msg +" "+emp.getName();
				}
			}
			return "No record present";
			}catch(Exception e) {
				logger.error(e.toString());
				return "No record present exception resolved";
			}
	}
}






