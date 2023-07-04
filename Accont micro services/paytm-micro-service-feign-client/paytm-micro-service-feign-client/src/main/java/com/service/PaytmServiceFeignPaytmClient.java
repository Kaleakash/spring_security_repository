package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PAYTMMICROSERVICE")		// service name 
public interface PaytmServiceFeignPaytmClient {

	@GetMapping(value = "paytm/findAccountNumber/{emailid}")
	public int findAccountNumber(@PathVariable("emailid") String emailid);
}
