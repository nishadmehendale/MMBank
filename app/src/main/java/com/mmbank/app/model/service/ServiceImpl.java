package com.mmbank.app.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmbank.app.model.dao.DAOImpl;
import com.mmbank.framework.account.pojo.BankAccount;
import com.mmbank.framework.account.pojo.Customer;
import com.mmbank.framework.account.pojo.PaymentGateway;

@Service
public class ServiceImpl {
	@Autowired
	DAOImpl dao /*= new DAOImpl()*/;
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#addBankAccount(com.moneymoney.framework.account.pojo.BankAccount)
	 */

	public void addBankAccount(BankAccount bankAccount) {
		System.out.println(bankAccount);
		dao.addBankAccount(bankAccount);
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#viewAll()
	 */

	public ArrayList<BankAccount> viewAllAccounts(){
		return dao.viewAllAccounts();
	}
	
	/* (non-Javadoc)
	 * @see com.moneymoney.framework.service.Service#FundTransfer(com.moneymoney.framework.account.pojo.BankAccount, com.moneymoney.framework.account.pojo.BankAccount, double)
	 */

	public boolean FundTransfer(BankAccount sender,BankAccount reciever,double amount) {
		return PaymentGateway.transfer(sender, reciever, amount);
	}

	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}
	
	public ArrayList<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return dao.viewAllCustomers();
	}

	public BankAccount searchAccountById(int num) throws NullPointerException{
		// TODO Auto-generated method stub
		return dao.searchAccountById(num);
	}
	
	public Customer searchCustomerById(int num) throws NullPointerException{
		return dao.searchCustomerById(num);
	}
	
	public String withdraw(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		return account.withdraw(amount);		
	}
	public void deposit(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		account.deposit(amount);		
	}
}
