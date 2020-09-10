package com.wipro.customermanagement.service;

import java.util.List;

import com.wipro.customermanagement.entity.Customer;

public interface CustomerService {

	
	Customer addCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
  
	Customer findOne(int id);
	
    Customer updateCustomer(Customer customer);
	
    void remove(Customer cust);
	   
}
