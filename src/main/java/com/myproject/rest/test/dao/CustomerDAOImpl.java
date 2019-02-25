package com.myproject.rest.test.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.rest.test.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer theCustomer = currentSession.get(Customer.class,theId);
		return theCustomer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

}
