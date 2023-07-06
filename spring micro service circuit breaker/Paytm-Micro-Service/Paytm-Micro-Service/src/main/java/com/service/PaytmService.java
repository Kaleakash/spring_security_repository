package com.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Paytm;
import com.repository.PaytmRepository;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class PaytmService {

	@Autowired
	PaytmRepository paytmRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String createPaytmAccount(Paytm paytm) {
		Optional<Paytm> result = paytmRepository.findById(paytm.getEmailid());
		if(result.isPresent()) {
			return "Account already registered";
		}else {
			paytmRepository.save(paytm);
			return "Paytm account created successfully";
		}
	}
	
	@Retry(name = "myRetry",fallbackMethod = "defaultMethodInformation")
	public String findBalance(String emailid) {
		Optional<Paytm> result = paytmRepository.findById(emailid);
		if(result.isPresent()) {
			Paytm pp = result.get();
			int accno = pp.getAccno();
			//return 	restTemplate.getForObject("http://localhost:9191/account/findBalance/"+accno, String.class);
			System.out.println("Client Call this service at "+LocalDateTime.now());
			return 	restTemplate.getForObject("http://accountservice/account/findBalance/"+accno, String.class);
		}else {
			return "Paytm account not present";
		}
	}
	
	public String defaultMethodInformation(Exception e) {
		return "Account service is down";
	}
	
	public int findAccountNumber(String emailid) {
		Optional<Paytm> result = paytmRepository.findById(emailid);
		if(result.isPresent()) {
			Paytm pp = result.get();
			int accno = pp.getAccno();
			return accno;
		}else {
			return -1;
		}
	}
}
