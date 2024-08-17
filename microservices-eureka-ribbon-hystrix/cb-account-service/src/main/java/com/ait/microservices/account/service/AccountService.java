package com.ait.microservices.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ait.microservices.account.exceptions.AccountNotFoundException;
import com.ait.microservices.account.model.Account;

@Service
public class AccountService {
	protected Logger LOG = Logger.getLogger(AccountService.class.getName());
	@Value("${server.port}")
	int port;
	
	private List<Account> accounts;
	public AccountService() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111"));
		accounts.add(new Account(2, 2, "222222"));
		accounts.add(new Account(3, 3, "333333"));
		accounts.add(new Account(4, 4, "444444"));
		accounts.add(new Account(5, 1, "555555"));
		accounts.add(new Account(6, 2, "666666"));
		accounts.add(new Account(7, 2, "777777"));
	}
	
	public List<Account> findByCustomer(Integer customerId){
		LOG.log(Level.INFO, "findByCustomerId()  is calling in Account Service for customerId: " + customerId);
		if (port%2 == 0) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	public Account findByNumber(String number) {
		LOG.log(Level.INFO, "findByNumber()  is calling in Account Service for account number: " + number);
		Account acct = accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
		if (acct == null) {
			LOG.log(Level.WARNING, "findByNumber()  is calling in Account Service for account: " + number);
			throw new AccountNotFoundException("Account not found by account no: "+number);
		}
		return acct;
	}
	
	public List<Account> findAll() {
		LOG.log(Level.INFO, "findAll()  is calling in Account Service for all account list");
		return accounts;
	}
	

}
