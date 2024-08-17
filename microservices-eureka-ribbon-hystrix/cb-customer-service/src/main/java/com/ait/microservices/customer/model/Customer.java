package com.ait.microservices.customer.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {

	private Integer id;
	private String customerId;
	private String name;
	private CustomerType type;
	private List<Account> accounts;

	public Customer() {

	}

	public Customer(Integer id, String customerId, String name, CustomerType type) {
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.type = type;
	}

}
