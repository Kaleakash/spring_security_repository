package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "ACCOUNTSERVICE")		// service name 
public interface PaytmServiceFeignAccountClient {

	
	@GetMapping(value = "account/findBalance/{accno}")	// this method base upon consumer service 
	public String findBalaceFromAccountService(@PathVariable("accno") int accno);
	
//	@GetMapping(value="account/findDetails/{accno}")
//	public Account findAccountDetails(@PathVariable("accno") int accno);
}
