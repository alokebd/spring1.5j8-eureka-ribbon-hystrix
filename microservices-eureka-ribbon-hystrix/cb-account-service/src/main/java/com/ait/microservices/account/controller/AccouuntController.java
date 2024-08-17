package com.ait.microservices.account.controller;


import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ait.microservices.account.model.Account;
import com.ait.microservices.account.service.AccountService;

@RestController
public class AccouuntController {
	
	protected Logger logger = Logger.getLogger(AccouuntController.class.getName());
	private AccountService accountService;
	
	@Autowired
	public AccouuntController(AccountService accountService) {
		this.accountService=accountService;
	}
		
	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return accountService.findByNumber(number);
	}
	
	@RequestMapping("/accounts/customer/{customerId}")
	public List<Account> findByCustomer(@PathVariable("customerId") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accountService.findByCustomer(customerId);
	}
	
	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accountService.findAll();
	}
	
}
