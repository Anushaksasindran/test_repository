package com.cusapp.model.persistence;

import java.util.List;

public interface CustomerDao {
	
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomerById(int customer_Id);
	public Customer removeCustomer(int customer_Id);
	

}
