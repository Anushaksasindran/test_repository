package com.cusapp.model.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		return factory.getCurrentSession();

	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {

		return getSession().createQuery("from Customer").list();
	}
@Override
	public Customer addCustomer(Customer customer) {
	 getSession().save(customer);
	 return customer;
	}
@Override
	public Customer updateCustomer(Customer customer) {

		getSession().update(customer);
		return customer;
	}
@Override
	public Customer getCustomerById(int customer_Id) {

		return (Customer) getSession().get(Customer.class, customer_Id);
	}
@Override
	public Customer removeCustomer(int customer_Id) {

		Customer customerToBeDeleted = getCustomerById(customer_Id);
		getSession().delete(customerToBeDeleted);
		return customerToBeDeleted;
	}

}
