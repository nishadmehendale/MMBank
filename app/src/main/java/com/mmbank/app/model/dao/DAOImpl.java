package com.mmbank.app.model.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mmbank.framework.account.pojo.BankAccount;
import com.mmbank.framework.account.pojo.Customer;

/**
 * @author Satyen Singh
 * @author Nishad Mehendale
 *
 *         This is class for maintaining the list of all unique account objects.
 *
 *         This was created from the warm heart. The Developers are From
 *         capgemini.
 */

@Repository
public class DAOImpl {
	private static ArrayList<BankAccount> bankAccountSet;
	private static ArrayList<Customer> customerList;
	static {
		bankAccountSet = new ArrayList<>();
		customerList = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moneymoney.framework.account.dao.DAO#addBankAccount(com.moneymoney.
	 * framework.account.pojo.BankAccount)
	 */
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountSet.add(bankAccount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moneymoney.framework.account.dao.DAO#viewAll()
	 */
	public ArrayList<BankAccount> viewAllAccounts() {
		return bankAccountSet;
	}

	public void addCustomer(Customer customer) {
		System.out.println(customer + "cusosdkn");
		customerList.add(customer);
	}

	public ArrayList<Customer> viewAllCustomers() {
		return customerList;
	}

	public BankAccount searchAccountById(int num) throws NullPointerException {
		BankAccount account = null;
		for (BankAccount a : bankAccountSet) {
			if (a.getAccountNumber() == num) {
				account = a;
			}
		}
		if (account != null)
			return account;
		else
			throw new NullPointerException("Customer Not Found");
	}

	public Customer searchCustomerById(int num) throws NullPointerException {
		Customer customer = null;
		for (Customer c : customerList) {
			if (c.getCustomerId() == num) {
				customer = c;
			}
		}
		if (customer != null)
			return customer;
		else
			throw new NullPointerException("Customer Not Found");
	}
}
