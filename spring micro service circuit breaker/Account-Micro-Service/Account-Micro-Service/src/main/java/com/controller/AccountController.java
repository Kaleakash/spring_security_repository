package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Account;
import com.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account acocunt) {
		return accountService.createAccount(acocunt);
	}

	@GetMapping(value="findBalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno) {
		return accountService.findBalance(accno);
	}
	
	@GetMapping(value="findDetails/{accno}")
	public Account findAccountDetails(@PathVariable("accno") int accno) {
		return accountService.findAccountDetails(accno);
	}
	
	@PutMapping(value="withdraw/{accno}/{amount}")
	public String withdraw(@PathVariable("accno") int accno, @PathVariable("amount") float amount) {
		return accountService.withDraw(accno, accno);
	}
}
