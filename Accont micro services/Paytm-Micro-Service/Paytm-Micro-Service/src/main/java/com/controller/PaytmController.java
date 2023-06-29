package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Paytm;
import com.service.PaytmService;

@RestController
@RequestMapping("paytm")
public class PaytmController {

	@Autowired
	PaytmService paytmService;
	
	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createPaytmAccount(@RequestBody Paytm paytm) {
		return paytmService.createPaytmAccount(paytm);
	}
	@GetMapping(value = "findBalance/{emailid}")
	public String findBalance(@PathVariable("emailid") String emailid) {
		return paytmService.findBalance(emailid);
	}
}
