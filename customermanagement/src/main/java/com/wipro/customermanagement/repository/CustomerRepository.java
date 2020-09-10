package com.wipro.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.customermanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByName(String name);
	//service.retrieveCustomers(name);
	
	
	//service.addCustomer(Customer customer);
	//service.updateCustomer(Customer customer);
	//service.retrieveCustomer(int id);
	//service.deleteCustomer(int id);	

}
