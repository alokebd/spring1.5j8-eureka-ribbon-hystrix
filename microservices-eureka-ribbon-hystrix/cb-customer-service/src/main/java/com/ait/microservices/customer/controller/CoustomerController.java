package com.ait.microservices.customer.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.microservices.customer.model.Customer;
import com.ait.microservices.customer.service.CustomerService;


@RestController
public class CoustomerController {
	
	protected Logger logger = Logger.getLogger(CoustomerController.class.getName());
	
	private CustomerService customerService;
    @Autowired
	public CoustomerController(CustomerService customerService) {
    	this.customerService =customerService;
    }
	

	@RequestMapping("/customers/customerId/{id}")
	public Customer findByCustomerId(@PathVariable("id") String id) {
		logger.info(String.format("Customer.findByCustomerId(%s)", id));
		return customerService.findByCustomerId(id);
	}
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customerService.findAll();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		return customerService.findById(id);
	}
	
}
