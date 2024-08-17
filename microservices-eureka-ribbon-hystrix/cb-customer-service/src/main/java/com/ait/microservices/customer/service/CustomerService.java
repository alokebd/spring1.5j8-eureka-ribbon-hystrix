package com.ait.microservices.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ait.microservices.customer.client.AccountClient;
import com.ait.microservices.customer.exceptions.CustomerNotFoundException;
import com.ait.microservices.customer.model.Account;
import com.ait.microservices.customer.model.Customer;
import com.ait.microservices.customer.model.CustomerType;

@Service
public class CustomerService {
	protected Logger LOG = Logger.getLogger(CustomerService.class.getName());
	@Autowired
	private AccountClient accountClient;
	
	private List<Customer> customers;
	
	public CustomerService() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "12345", "Alex", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "12346", "James", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "12347", "APEX", CustomerType.COMPANY));
		customers.add(new Customer(4, "12348", "Karolina", CustomerType.INDIVIDUAL));
	}
	
	public Customer findByCustomerId(String id) {
		LOG.log(Level.INFO, "findByCustomerId()  is calling in Customer Service for Id: " + id);
		Customer customer= customers.stream().filter(it -> it.getCustomerId().equals(id)).findFirst().get();	
		if (customer == null) {
			LOG.log(Level.WARNING, "findByCustomerId()  is calling in Customer Service for Id: " + id);
			throw new CustomerNotFoundException("Customer not found by id: "+id);
		}
		return customer;
	}
	
		
	public List<Customer> findAll(){
		LOG.log(Level.INFO, "findAll()  is calling in Customer Service for all customer list");
		return customers;
	}
	
	/*This call have Circuit-Breaker & Fallback implementation */
	public Customer findById(Integer id) {
		LOG.log(Level.INFO, "findById()  is calling in Customer Service for Id:" + id);
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}
}
