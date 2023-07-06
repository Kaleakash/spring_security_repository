package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Customer;

@RestController
@RequestMapping("customer")
public class CustomerController {

	static List<Customer> listOfCustomer;
	
	static {
		listOfCustomer =Arrays.asList(new Customer("Ravi", 23),new Customer("Vijay", 26),new Customer("Ajay", 29),new Customer("Ramesh", 31));
	}
	
	@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAllCustomer() {
		return listOfCustomer;
	}
}
