package com.mmbank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmbank.app.model.service.ServiceImpl;

@RestController
public class TransactionController {
	@Autowired
	ServiceImpl service;
	
	@RequestMapping(value = "/deposit/{accNo}/{amount}", method = RequestMethod.POST)
	public void deposit(@PathVariable int accNo,@PathVariable double amount) {
		service.deposit(accNo, amount);
	}

	@RequestMapping(value = "/withdraw/{accNo}/{amount}", method = RequestMethod.POST)
	public void withdraw(@PathVariable int accNo,@PathVariable double amount) {
		service.withdraw(accNo, amount);
	}

	@RequestMapping(value = "/fundtransfer/{sender}//{receiver}/{amount}", method = RequestMethod.POST)
	public void fundTransfer(@PathVariable int sender,@PathVariable int receiver,@PathVariable double amount) {
		service.FundTransfer(service.searchAccountById(sender), service.searchAccountById(receiver), amount);
	}
	
}
