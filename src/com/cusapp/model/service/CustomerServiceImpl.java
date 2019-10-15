package com.cusapp.model.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cusapp.model.persistence.Customer;
import com.cusapp.model.persistence.CustomerDao;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int customer_Id) {
		
		return customerDao.getCustomerById(customer_Id);
	}

	@Override
	public Customer removeCustomer(int customer_Id) {
		
		return customerDao.removeCustomer(customer_Id);
	}

}
