package com.ait.microservices.customer.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ait.microservices.customer.model.Account;

@Component
public class AccountFallback implements AccountClient {

	@Override
	public List<Account> getAccounts(Integer customerId) {
		List<Account> acc = new ArrayList<Account>();
		acc.add(new Account(0, "Default"));
		return acc;
	}
	
}
