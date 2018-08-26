package com.mmbank.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmbank.app.model.service.ServiceImpl;
import com.mmbank.framework.account.pojo.BankAccount;
import com.mmbank.framework.account.pojo.Customer;

@RestController
public class DetailsController {
	@Autowired
	ServiceImpl service;

	@RequestMapping(value = "/customers")
	public ArrayList<Customer> viewAllCustomers() {

		return service.viewAllCustomers();
	}

	@RequestMapping(value = "/accounts")
	public ArrayList<BankAccount> viewAllAccounts() {

		return service.viewAllAccounts();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/accounts/{accountNumber}")
	public Resource viewAccount(@PathVariable int accountNumber) {
		try {
			BankAccount account = service.searchAccountById(accountNumber); 
			return new Resource(account);
		}
		catch(NullPointerException ne) {
			return new Resource(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/customers/{customerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable int customerId) {
		try {
		Customer customer = service.searchCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		catch(NullPointerException ne) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
