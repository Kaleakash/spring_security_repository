package com.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			return "Account number must be unique";
		}else {
			accountRepository.save(account);
			return "Account created";
		}
	}
	
	public String findBalance(int accno) {
		System.out.println("Client send request "+new Date());
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return "Your account balance is "+acc.getAmount()+" with account as "+accno;
		}else {
			return "InValid account number";
		}
	}
	
	public Account findAccountDetails(int accno) {
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return acc;
		}else {
			return null;
		}
	}
	
	public String withDraw(int accno, float amount) {
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			acc.setAmount(acc.getAmount()-amount);
			accountRepository.saveAndFlush(acc);
			return "Amount withdrawn successfully";
		}else {
			return "Invalid account number "+accno;
		}
	}
	
}




