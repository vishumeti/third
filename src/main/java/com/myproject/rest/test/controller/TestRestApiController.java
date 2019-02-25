package com.myproject.rest.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.rest.test.dao.CustomerDAO;
import com.myproject.rest.test.entity.Customer;

@RestController
@RequestMapping("/api")
public class TestRestApiController {

	private CustomerDAO customerDAO;

	@Autowired
	public TestRestApiController(CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}
	
	@GetMapping("/customers")
	public List<Customer> findAll(){
		return customerDAO.findAll();
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer findById(@PathVariable int customerId) {
		Customer theCustomer = customerDAO.findById(customerId);
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer save(@RequestBody Customer customer) {
		customerDAO.save(customer);	
		return customer;
	}
	
	@PutMapping("/customer/{customerId}")
	public Customer updateId(@RequestBody Customer customer) {
		customerDAO.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{customerId}")
	public String deleteById(@PathVariable int customerId) {
		customerDAO.deleteById(customerId);
		return "Deleted"+ customerId;
	}
}
