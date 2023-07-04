package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.PaytmFeignService;
import com.service.PaytmServiceFeignAccountClient;

@RestController
@RequestMapping("paytm-feign-client")
public class PaytmController {

	@Autowired
	PaytmServiceFeignAccountClient paytmServiceFiegnClient;
	
	@Autowired
	PaytmFeignService paytmFeignService;
	
	@GetMapping(value = "findBalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno) {
		
		
		return paytmServiceFiegnClient.findBalaceFromAccountService(accno);
	}
	
	@GetMapping(value = "findBalanceByEmailid/{emailid}")
	public String findBalaceByEmailId(@PathVariable("emailid") String emailid) {
		return paytmFeignService.findBalance(emailid);
	}
}
