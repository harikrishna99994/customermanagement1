package com.wipro.customermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customermanagement.entity.Customer;
import com.wipro.customermanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}
	
	public Customer findOne(int id) {
		return repo.getOne(id);
	}
	
	public Customer updateCustomer(Customer customer) {
		 Customer cust = repo.getOne(customer.getId());
		 cust.setId(customer.getId());
		 cust.setName(customer.getName());
		 cust.setEmail(customer.getEmail());
		 cust.setAddress(customer.getAddress());
		 Customer updatedCustomer = cust;
		return updatedCustomer;
	}
	public void remove(Customer cust) {
		repo.delete(cust);
	}



}
