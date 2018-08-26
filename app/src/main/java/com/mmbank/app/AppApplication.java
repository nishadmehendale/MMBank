package com.mmbank.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mmbank.app.model.account.pojo.MMCurrentAccount;
import com.mmbank.app.model.account.pojo.MMCustomer;
import com.mmbank.app.model.account.pojo.MMSavingsAccount;
import com.mmbank.app.model.service.ServiceImpl;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Start(ServiceImpl service) {
		return (args)-> {
			MMCustomer c1 = new MMCustomer("Nishad", 1212121, "08/11/1996", "n@m.com");
			MMCustomer c2 = new MMCustomer("Sayali", 2121212, "29/10/1996", "s@m.com");
			MMCustomer c3 = new MMCustomer("Drishti", 1313131, "12/12/1996", "d@r.com");
			
			MMSavingsAccount ms1 = new MMSavingsAccount(c1, 20000, true);
			MMSavingsAccount ms2 = new MMSavingsAccount(c2, 40000, false);
			MMSavingsAccount ms3 = new MMSavingsAccount(c3, 60000, true);
			
			MMCurrentAccount mc1 = new MMCurrentAccount(c1, 19999, 10000);
			MMCurrentAccount mc2 = new MMCurrentAccount(c2, 39999, 10000);
			MMCurrentAccount mc3 = new MMCurrentAccount(c3, 59999, 10000);
			
			c1.setAccountNumber(ms1.getAccountNumber());
			c1.setAccountNumber(mc1.getAccountNumber());
			c2.setAccountNumber(ms2.getAccountNumber());
			c2.setAccountNumber(mc2.getAccountNumber());
			c3.setAccountNumber(ms3.getAccountNumber());
			c3.setAccountNumber(mc3.getAccountNumber());
			
			service.addBankAccount(ms1);
			service.addBankAccount(ms2);
			service.addBankAccount(ms3);
			service.addBankAccount(mc1);
			service.addBankAccount(mc2);
			service.addBankAccount(mc3);
			
			service.addCustomer(c1);
			service.addCustomer(c2);
			service.addCustomer(c3);
			
			System.out.println(service.viewAllAccounts().size()+" skjhadka "+service.viewAllCustomers().size());

		};
	}
}
