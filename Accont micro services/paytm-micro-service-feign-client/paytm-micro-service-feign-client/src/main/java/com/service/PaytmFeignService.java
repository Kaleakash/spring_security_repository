package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaytmFeignService {

	@Autowired
	PaytmServiceFeignAccountClient paytmServiceFeignAccountClient;
	
	@Autowired
	PaytmServiceFeignPaytmClient paytmServiceFeignPaytmClient; 
	
	public String findBalance(String emailid) {
		int accno = paytmServiceFeignPaytmClient.findAccountNumber(emailid);
		if(accno==-1) {
			return "Paytm account doesn't exists";
		}else {
			return paytmServiceFeignAccountClient.findBalaceFromAccountService(accno);
		}
	}
}
