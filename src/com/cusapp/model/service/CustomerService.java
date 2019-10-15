package com.cusapp.model.service;

import java.util.List;

import com.cusapp.model.persistence.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomerById(int customer_Id);
	public Customer removeCustomer(int customer_Id);

}
