package com.myproject.rest.test.dao;

import java.util.List;

import com.myproject.rest.test.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer customer);
	
	public void deleteById(int id);
}
